package start;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import parser.Parser;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 15.01.2017
 *
 * Starter class. It main thread of app.
 */
public class Starter {

    /**
     * Instance of logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Starter.class);

    /**
     * Entry point of application.
     * @param args for app.
     */
    public static void main(String[] args) {
        new Starter().init();
    }

    /**
     * Init and start application.
     */
    private void init() {
        Settings settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        long repeatInterval = Long.parseLong(settings.getValue("REPEAT_INTERVAL"));
        JobDetail parserJob = newJob(Parser.class).build();
        Trigger trigger = newTrigger()
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(repeatInterval).repeatForever())
                .build();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(parserJob, trigger);
        } catch (SchedulerException exception) {
            LOGGER.log(Level.WARN, exception.getMessage(), exception);
        }
    }
}
