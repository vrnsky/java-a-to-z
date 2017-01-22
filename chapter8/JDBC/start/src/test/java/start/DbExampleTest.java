package start;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.01.2017
 *
 * //FIXME develop db test
 */
public class DbExampleTest extends DBTestCase {


    public DbExampleTest(String testName) {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                "org.postgresql.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                "jdbc:postgresql://localhost:5432/parser");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
                "postgres");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
                "555555");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA,
                "DB_SCHEMA");
    }


    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(getClass().getClassLoader().getResourceAsStream("dataset.xml"));
    }


    public void testUpdateAllSalaries() throws Exception {
        Tracker tracker = new Tracker();
        tracker.addItem(new Item());

        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("items");

        IDataSet expectedDataSet = new FlatXmlDataSet(getClass().getResourceAsStream("expectedDataSet.xml"));

        ITable expectedTable = expectedDataSet.getTable("items");
        ITable filteredActualTable = DefaultColumnFilter.includedColumnsTable(actualTable, expectedTable.getTableMetaData().getColumns());

        Assertion.assertEquals(expectedTable, filteredActualTable);
    }
}
