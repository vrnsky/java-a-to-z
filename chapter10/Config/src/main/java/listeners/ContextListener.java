package listeners;

import database.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author evrnsky
 * @version 0.1
 * @since 26.03.2017
 * //TODO when context created should create session factory and when context destroy should close session factory
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBManager.getInstance().buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBManager.getInstance().closeSessionFactory();
    }
}
