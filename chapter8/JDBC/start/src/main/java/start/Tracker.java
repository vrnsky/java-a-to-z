package start;
import models.Comment;
import models.Item;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author evrnsky (voronyansky.egor@yandex.ru)
 * @version 0.1
 * @since 04.01.2017
 * This full copy of already writted tracked which have in memory storage.
 * This tracker store all items at the PostgreSQL.
 */
public class Tracker {

    /**
     * SQl statement for insert new item to the database.
     */
    private static final String INSERT = "insert into items(item_name, description, create_time) values(?, ?, ?)";

    /**
     * SQL statement for update already in database item.
     */
    private static final String UPDATE = "update items set item_name = ?, description = ? where id = ?";

    /**
     * SQL statement for remove item from database.
     */
    private static final String DELETE = "delete from items where id = ?";

    /**
     * SQL statement for take all items from database.
     */
    private static final String SELECT_ALL = "select * from items";

    /**
     * SQL statement for filtering items by text.
     */
    private static final String FILTER_BY_TEXT = "select * from items where item_name like ? or description like ?";

    /**
     * SQL statemtent filter by text.
     */
    private static final String TIME_FILTER = "select * from items where create_time > ?";

    /**
     * SQL statement for adding comments.
     */
    private static final String ADD_COMMENTS = "insert into comments(text, item_id) values(?, ?)";

    /**
     * SQL statement for getting comments for determine item.
     */
    private static final String GET_COMMENTS = "select text from comments where item_id = ?";

    /**
     * SQL statement for count all rows in table.
     */
    private static final String COUNT_OF_ROWS = "select count(*) from items";


    /**
     * Name of column at the items table which describe name of item.
     */
    private static final String NAME_COLUMN = "item_name";

    /**
     * Name of column at the items table which describe description of item.
     */
    private static final String DESC_COLUMN = "description";

    /**
     * Name of column at the items table which describe id of item.
     */
    private static final String ID_COLUMN = "id";

    /**
     * Name of column at the items tabel which describe item's creation time.
     */
    private static final String TIME_COLUMN = "create_time";

    /**
     * URL for connect to the tracker database.
     */
    private static final String URL = "jdbc:postgresql://localhost:5432/tracker";

    /**
     * User for database server.
     */
    private static final String USER = "postgres";

    /**
     * Password for database server.
     */
    private static final String PASSWORD = "55555";

    /**
     * Instance of connection to the database.
     */
    private Connection connection;

    /**
     * Flag which say us that we already connect to the database.
     */
    private boolean connected = false;

    /**
     * SQL statement for avoid SQL injection.
     */
    private PreparedStatement sqlStatement;

    /**
     * Data returned from database.
     */
    private ResultSet set;

    /**
     * Default constructor.
     */
    public Tracker() {
    }

    /**
     * Adding new item to the database.
     * @param item instance of item class.
     * @return given item with set up id.
     */
    public Item addItem(Item item) {
        connect();
        try {
            this.sqlStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            this.sqlStatement.setString(1, item.getName());
            this.sqlStatement.setString(2, item.getDescription());
            this.sqlStatement.setTimestamp(3, new Timestamp(item.getCreateTime()));
            this.sqlStatement.executeUpdate();
            this.set = sqlStatement.getGeneratedKeys();
            while (this.set.next()) {
                item.setId(String.valueOf(set.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
            closeResultSet();
            closeStatement();
        }
        return item;
    }

    /**
     * Edit already in database item.
     * @param item new version of item.
     * @return updated item.
     */
    public Item editItem(Item item) {
        connect();
        try {
            this.sqlStatement = connection.prepareStatement(UPDATE);
            this.sqlStatement.setString(1, item.getName());
            this.sqlStatement.setString(2, item.getDescription());
            this.sqlStatement.setInt(3, Integer.valueOf(item.getId()));
            this.sqlStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeStatement();
        }
        return item;
    }

    /**
     * Remove item from database.
     * @param itemId unique per item number.
     * @return count of removed rows from tables.
     */
    public int removeItem(String itemId) {
        int id = Integer.valueOf(itemId);
        int removed = 0;
        connect();
        try {
            this.sqlStatement = connection.prepareStatement(DELETE);
            this.sqlStatement.setInt(1, id);
            removed = this.sqlStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeStatement();
        }
        return removed;
    }

    /**
     * Return all items from database.
     * @return all items from database.
     */
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        Statement select = null;
        connect();
        try {
            select = connection.createStatement();
            this.set = select.executeQuery(SELECT_ALL);
            while (this.set.next()) {
                int id = this.set.getInt(ID_COLUMN);
                String name = this.set.getString(NAME_COLUMN);
                String desc = this.set.getString(DESC_COLUMN);
                long timestamp = this.set.getTimestamp(TIME_COLUMN).getTime();
                Item item = new Item(String.valueOf(id), name, desc, timestamp);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeResultSet();
            if (select != null) {
                try {
                    select.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return items;
    }

    /**
     * Return filtering by text items.
     * Filtering by text means that item name or item description contains some part of given text.
     * @param text string for search.
     * @return list of items which contain at it's name or description given text.
     */
    public List<Item> filteringByText(final String text) {
        List<Item> items = new ArrayList<>();
        connect();
        try {
            this.sqlStatement = connection.prepareStatement(FILTER_BY_TEXT);
            this.sqlStatement.setString(1, String.format("%s%s%s", "%", text, "%"));
            this.sqlStatement.setString(2, String.format("%s%s%s", "%", text, "%"));
            this.set = this.sqlStatement.executeQuery();
            while (set.next()) {
                int id = this.set.getInt(ID_COLUMN);
                String name = this.set.getString(NAME_COLUMN);
                String description = this.set.getString(DESC_COLUMN);
                long createTime = this.set.getTimestamp(TIME_COLUMN).getTime();
                Item item = new Item(String.valueOf(id), name, description, createTime);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeStatement();
            this.closeResultSet();
        }
        return items;
    }

    /**
     * Filtering by time. Search at the database item which was created after given time.
     * @param time for specify search.
     * @return list of items which was created after given time.
     */
    public List<Item> filteringByTime(final long time) {
        List<Item> items = new ArrayList<>();
        try {
            this.sqlStatement = connection.prepareStatement(TIME_FILTER);
            this.sqlStatement.setTimestamp(1, new Timestamp(time));
            this.set = this.sqlStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt(ID_COLUMN);
                String name = set.getString(NAME_COLUMN);
                String desc = set.getString(DESC_COLUMN);
                long createTime = set.getTimestamp(TIME_COLUMN).getTime();
                Item item = new Item(String.valueOf(id), name, desc, createTime);
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeStatement();
            this.closeResultSet();
        }
        return items;
    }

    /**
     * Add comments to the comments table.
     * @param item instance of item class.
     * @param text of comment.
     */
    public void addComment(Item item, String text) {
        this.connect();
        try {
            this.sqlStatement = this.connection.prepareStatement(ADD_COMMENTS);
            this.sqlStatement.setString(1, text);
            this.sqlStatement.setInt(2, Integer.valueOf(item.getId()));
            this.sqlStatement.executeUpdate();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeStatement();
        }
    }


    /**
     * Return all comments per item.
     * @param item instance of item.
     * @return list of comments for given item.
     */
    public List<Comment> getComments(Item item) {
        List<Comment> comments = new ArrayList<>();
        this.connect();
        try {
            this.sqlStatement = this.connection.prepareStatement(GET_COMMENTS);
            this.sqlStatement.setInt(1, Integer.valueOf(item.getId()));
            this.set = sqlStatement.executeQuery();
            while (set.next()) {
                comments.add(new Comment(set.getString("text")));
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        return comments;
    }

    /**
     * Always return zero. It makes because all structure zero base.
     * @return zero.
     */
    public int getStart() {
        return 0;
    }

    /**
     * Return count of rows in items table - that means count of all items at the tracker.
     * @return count of all items at the tracker.
     */
    public int getFinish() {
        int count = 0;
        connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            this.set = statement.executeQuery(COUNT_OF_ROWS);
            while (this.set.next()) {
                count = this.set.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
            this.closeResultSet();
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    /**
     * Set up connection to the database.
     */
    private void connect() {
        if (!connected) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close connection to the database.
     */
    private void closeConnection() {
        if (this.connected && connection != null) {
            try {
                connection.close();
                this.connected = false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close result set which return database.
     */
    private void closeResultSet() {
        if (this.set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close sql statement.
     */
    private void closeStatement() {
        if (this.sqlStatement != null) {
            try {
                sqlStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
