package parser;

import db.PermanentStorage;
import start.Settings;
import start.TextSimilarityChecker;
import start.Vacancy;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.01.2017
 *
 * Main class of parser. It parsing vacancy and adding it to database.
 */
public class Parser implements Job {


    /**
     * Instance of logger.
     */
    private static final Logger LOGGER = Logger.getLogger(Parser.class);

    /**
     * Root page for parsing.
     */
    private static final String ROOT_PAGE = "http://www.sql.ru/forum/job-offers";

    /**
     * Slash.
     */
    private static final String SLASH = "/";

    /**
     * Class which contains job offer.
     */
    private static final String JOB_ROW = "postslisttopic";

    /**
     * Anchor tag, for moving to the job offer page.
     */
    private static final String ANCHOR_TAG = "a";

    /**
     * Attribute of anchor href.
     */
    private static final String HREF_ATTRIBUTE = "href";

    /**
     * Main message of job offer, contains at this element.
     */
    private static final String MSG_BODY = "msgBody";

    /**
     * Element for parsing time.
     */
    private static final String MSG_FOOTER = "msgFooter";

    /**
     * Element for parsing time.
     */
    private static final String TD_TAG = "td";

    /**
     * Flag which means that first start of app.
     */
    private boolean firstStart;

    /**
     * Date parser, which parse date.
     */
    private DateParser dateParser;

    /**
     * Instance of permanent storage which provide access to the database.
     */
    private PermanentStorage storage;

    /**
     * Text similiraty checker, check that texts are similar.
     */
    private TextSimilarityChecker similarityChecker;

    /**
     * Settings for provide access to the settings app.
     */
    private Settings settings;

    /**
     * Instance of this class.
     */
    private Parser parser;

    /**
     * Default constructor.
     */
    public Parser() {
        this.settings = new Settings();
        settings.load(Settings.class.getClassLoader().getResourceAsStream("app.properties"));
        this.firstStart = Boolean.parseBoolean(settings.getValue("FIRST_START"));
        this.dateParser = new DateParser();
        this.storage = new PermanentStorage();
        this.similarityChecker = new TextSimilarityChecker();
    }

    /**
     * Method which executing as async task.
     * @param jobExecutionContext context for executing job.
     * @throws JobExecutionException if something problem with scheduler.
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if (this.parser == null) {
            this.parser = new Parser();
        }
        this.parser.startSearch();
    }

    /**
     * Start parsing.
     */
    private void startSearch() {
        LOGGER.log(Level.INFO, "Parser start search offers.");
        List<Vacancy> offers = new ArrayList<>(100);
        try {
            if (this.firstStart) {
                offers = this.getVacancyAtYearStart();
                this.settings.write("FIRST_START", "FALSE");
            } else {
                offers = this.collectVacancy();
            }
        } catch (IOException ioe) {
            LOGGER.log(Level.WARN, ioe.getMessage(), ioe);
        }
        this.addVacanciesToDatabase(offers);
    }

    /**
     * Add vacancies to the database.
     * @param vacancies list of vacancies.
     */
    private void addVacanciesToDatabase(List<Vacancy> vacancies) {
        ResultSet set = null;
        for (Vacancy vacancy : vacancies) {
            if (!(this.similarityChecker.haveSimilarVacancy(vacancy.getRequirements()))) {
                set = this.storage.addVacancy(vacancy);
                try {
                    while (set.next()) {
                        vacancy.setId(set.getInt("id"));
                    }
                } catch (SQLException sql) {
                    LOGGER.log(Level.INFO, sql.getMessage(), sql);
                } finally {
                    if (set != null) {
                        try {
                            set.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * Collect recently vacancies which placed at the root page.
     * @return recently vacancies.
     */
    private List<Vacancy> collectVacancy() {
        List<Vacancy> vacancies = new ArrayList<>(100);
        try {
            Document document = Jsoup.connect(ROOT_PAGE).get();
            Elements jobsOffers = document.getElementsByClass(JOB_ROW);
            for (Element element : jobsOffers) {
                if (isGoodVacancy(element.text())) {
                    vacancies.add(parseVacancy(element));
                }
            }
        } catch (IOException ioex) {
            LOGGER.log(Level.WARN, ioex.getMessage(), ioex);
        }

        return vacancies;
    }

    /**
     * Parse vacancy from the year start.
     * @return all vacancies from the year start.
     * @throws IOException if problem with connect to the site.
     */
    private List<Vacancy> getVacancyAtYearStart() throws IOException {
        List<Vacancy> vacancies = new ArrayList<>(100);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        Document rootPage = null;
        for (int index = 0; index < 3;) {
            if (index == 0) {
                rootPage = Jsoup.connect(ROOT_PAGE).get();
                Elements jobsOffers = rootPage.getElementsByClass(JOB_ROW);
                vacancies.addAll(parseSheetOfWorks(jobsOffers, calendar.get(Calendar.YEAR)));
            } else {
                rootPage = Jsoup.connect(String.format("%s%s%s", ROOT_PAGE, SLASH, index)).get();
                Elements jobsOffers = rootPage.getElementsByClass(JOB_ROW);
                vacancies.addAll(parseSheetOfWorks(jobsOffers, calendar.get(Calendar.YEAR)));
            }
            index++;
        }
        return vacancies;
    }

    /**
     * Parse a page from forum and create a list of good job offer.
     * @param jobsOffers elements of html which intresting for searching vacancy.
     * @param year specify time.
     * @return list of vacancies.
     */
    private List<Vacancy> parseSheetOfWorks(Elements jobsOffers, int year) {
        List<Vacancy> vacancies = new ArrayList<>(100);
        for (Element element : jobsOffers) {
            if (isGoodVacancy(element.text())) {
                vacancies.add(parseVacancy(element));
            }
        }
        this.removeOlderVacancies(vacancies, year);
        return vacancies;
    }

    /**
     * Removing vacancies which was published after given time.
     * @param vacancies list of vacancy.
     * @param year specify time.
     */
    private void removeOlderVacancies(List<Vacancy> vacancies, int year) {
        Calendar calendar = Calendar.getInstance();
        Iterator<Vacancy> iterator = vacancies.iterator();
        while (iterator.hasNext()) {
            Vacancy vacancy = iterator.next();
            calendar.setTimeInMillis(vacancy.getPublishTime());
            if (calendar.get(Calendar.YEAR) < year) {
                iterator.remove();
            }
        }
    }

    /**
     * Checking that vacancy that is suitable for java.
     * @param title of job offer.
     * @return true if vacancy good, otherwise false.
     */
    private boolean isGoodVacancy(String title) {
        boolean goodness = false;
        boolean notContainsJS = !title.contains("JavaScript") && !title.contains("Java Script");
        boolean containJava = title.contains("Java") || title.contains("java");

        if (notContainsJS && containJava) {
            goodness = true;
        }
        return goodness;
    }

    /**
     * Parsing vacancy from work page.
     * @param worksTopic html element which contain link to the work page.
     * @return vacancy object.
     */
    private Vacancy parseVacancy(Element worksTopic) {
        Vacancy vacancy = null;
        String url = worksTopic.select(ANCHOR_TAG).attr(HREF_ATTRIBUTE);
        try {
            Document worksPage = Jsoup.connect(url).get();
            String description = worksPage.getElementsByClass(MSG_BODY).select(TD_TAG).text();
            LOGGER.log(Level.INFO, String.format("Found vacancy: %s", worksTopic.text()));
            LOGGER.log(Level.INFO, String.format("With next desc:\n%s", description));
            LOGGER.log(Level.INFO, String.format("Was published at: %s", this.getPublishDate(worksPage)));
            vacancy = new Vacancy(worksTopic.text(), description, this.dateParser.parseDate(getPublishDate(worksPage)), url);
        } catch (IOException ioe) {
            LOGGER.log(Level.WARN, ioe.getMessage(), ioe);
        } catch (ParseException par) {
            LOGGER.log(Level.WARN, par.getMessage(), par);
        }
        return vacancy;
    }

    /**
     * Return parseable data string.
     * @param doc element of html which contain time.
     * @return parseable string.
     */
    private String getPublishDate(Document doc) {
        return doc.getElementsByClass(MSG_FOOTER).get(0).text().split(",")[0];
    }


}
