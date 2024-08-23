package ru.evrnsky.start;

import ru.evrnsky.models.Comment;
import ru.evrnsky.models.Item;

/**
 * Implementation of tracker application.
 * Implement all functionality of tracker: add, remove, edit and comment.
 */
public class Tracker {


    /**
     * Default capacity of comments.
     */
    private static final int DEFAULT_CAPACITY_COMMENTS = 10;

    /**
     * Hold all items in this array.
     */
    private Item[] items;

    /**
     * For correct adding new item use pointer to choose correct position.
     */
    private int position;

    /**
     * Default constructor for tracker.
     * Create tracker app with 10 empty items.
     */
    public Tracker() {
        this(DEFAULT_CAPACITY_COMMENTS);
    }

    /**
     * Constructor for tracker.
     * @param size of items list.
     */
    public Tracker(final int size) {
        items = new Item[size];
        position = 0;
    }

    /**
     * Add item to items array.
     * @param item ready for adding object, it is also may be bug or task.
     * @return given item.
     */
    public final Item addItem(final Item item) {
        items[position++] = item;
        return item;
    }

    /**
     * Remove item from items array by set null at the array cell.
     * @param itemId unique string for each item.
     * @return removed item.
     */
    public final Item removeItem(final String itemId) {
        Item removed = findById(itemId);
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                if (items[index].getId().equals(removed.getId())) {
                    items[index] = null;
                }
            }
        }
        position = updateItemsList();
        return removed;
    }

    /**
     * This method move element in items array by collect not null.
     * Shift null elems and return new position - it is first null.
     * @return position for insert new elem.
     */
    private int updateItemsList() {
        for (int index = 0; index < items.length; index++) {
            for (int barrier = index + 1; barrier < items.length; barrier++) {
                if (items[index] == null && items[barrier] != null) {
                    items[index] = items[barrier];
                    items[barrier] = null;
                }
            }
        }

        int result = 0;
        while (items[result] != null) {
            result++;
        }

        return result;
    }

    /**
     * Find item which id is equals for given string.
     *
     * @param findId id for searching.
     * @return item which id equals findId, if item not found return null.
     */
    protected final Item findById(final String findId) {
        Item result = null;
        for (Item item : items) {
            if (item != null) {
                if (item.getId().equals(findId)) {
                    result = item;
                }
            }
        }
        return result;
    }

    /**
     * Edit item by set name and desc given parameters.
     *
     * @param item which need update.
     * @return updated item.
     */
    public final Item editItem(final Item item) {
        update(item);
        return item;
    }

    /**
     * Find item in array and set given item.
     * @param item will set at its place.
     */
    private void update(final Item item) {
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                if (items[index].getId().equals(item.getId())) {
                    items[index] = item;
                }
            }
        }
    }

    /**
     * Return all items which not null of tracker.
     * @return list of items.
     */
    public final Item[] getAllItems() {
        int size = 0;
        Item[] result;
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null) {
                size++;
            }
        }

        int startPosition = 0;
        int index = 0;
        result = new Item[size];
        while (index < items.length && startPosition < size) {
            Item current = items[index];
            if (current != null) {
                result[startPosition] = current;
                startPosition++;
            }
            index++;
        }

        return result;
    }

    /**
     * Return all items which name or description contain given string.
     * @param find text which will find.
     * @return list of item which name or description contain given string.
     */
    public final Item[] getItemsFilteredByText(final String find) {
        Item[] result = null;
        int size = 0;

        for (Item item : items) {
            if (item != null) {
                if (item.getName().contains(find)
                    || item.getDescription().contains(find)) {
                    size++;
                }
            }
        }

        result = new Item[size];

        int startPosition = 0;
        int index = 0;
        while (index < items.length && startPosition < size) {
            Item current = items[index];
            if (current != null) {
                if (current.getName().contains(find)
                    || current.getDescription().contains(find)) {
                    result[startPosition] = current;
                    startPosition++;
                }
            }
            index++;
        }

        return result;
    }

    /**
     * Return array of items which were created after given time.
     * @param createTime time for searching items.
     * @return list of items which be created after create time given in params.
     */
    public final Item[] getItemsFilteredByTime(final long createTime) {
        Item[] result = null;
        int size = 0;

        for (Item item : items) {
            if (item != null) {
                if (item.getCreateTime() > createTime) {
                    size++;
                }
            }
        }

        result = new Item[size];

        for (int index = 0; index < size; index++) {

            Item current = items[index];
            if (current != null) {
                if (current.getCreateTime() > createTime) {
                    result[index] = current;
                }
            }
        }

        return result;
    }

    /**
     * Add comment to item.
     * @param item from tracker.
     * @param comment which will be added.
     * @return given comment.
     */
    public final Comment addComment(final Item item, final Comment comment) {
        String id = item.getId();
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                if (items[index].getId().equals(id)) {
                    items[index].addComment(comment);
                }
            }
        }

        return comment;
    }

    /**
     * Return array of comment for current item.
     *
     * @param item in tracker.
     * @return list of all not null comments.
     */
    public final Comment[] getComments(final Item item) {
        return item.getComments();
    }

    /**
     * Return a position first position.
     * @return position of first element in items array.
     */
    public final int getStart() {
        return 0;
    }

    /**
     * Return position - place which must insert new element.
     * @return position of last not null item.
     */
    public final int getFinish() {
        return position;
    }
}
