package listeners;

import database.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 *
 * This context listener execute need for two reason.
 * 1.When app context created needs to open connect to the database.
 * 2.When app context destroyed need to close connect to the database.
 */
public class ContextListener implements ServletContextListener {

    /**
     * Open connection with database with help DBManager class, which inside use Hibernate.
     * @param sce instance of context event.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getInstance().buildSessionFactory();
    }

    /**
     * Close connection with database with help DBManager class, which inside use Hibernate.
     * @param sce instance of context event.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getInstance().closeSessionFactory();
    }
}
