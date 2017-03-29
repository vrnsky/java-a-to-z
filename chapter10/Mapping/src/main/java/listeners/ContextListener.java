package listeners;

import database.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 29.03.2017
 * <p>
 * This context listener needs for create connection to the database.
 * When context create should connect and when context destroyed should release connection.
 */
public class ContextListener implements ServletContextListener {

    /**
     * When context init should connected to the database.
     * @param sce information about event.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getInstance().init();
    }

    /**
     * When context destroyed should close connection.
     * @param sce information about event.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getInstance().close();
    }
}

