package ru.vrnsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vrnsky.robots.Robot;
/**
 * @author vrnsky.
 * @version 0.1
 *
 * This is a simple spring application..
 */
public class Application {

    /**
     * Entry point of application.
     * @param args keys for app.
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Robot robot = (Robot) context.getBean("robot");
        robot.turn();
    }
}
