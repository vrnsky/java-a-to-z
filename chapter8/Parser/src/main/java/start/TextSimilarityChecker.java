package start;

import db.PermanentStorage;
import org.apache.commons.lang3.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author evrnsky
 * @version 0.1
 * @since 08.01.2017
 *
 * This class provide check of similarity text.
 */
public class TextSimilarityChecker {

    /**
     * Instance of logger.
     */
    private static final Logger LOGGER = Logger.getLogger(TextSimilarityChecker.class.getSimpleName());

    /**
     * Instance of permanent storage. Provide access to the database.
     */
    private PermanentStorage storage;

    /**
     * Default constructor.
     */
    public TextSimilarityChecker() {
        this.storage = new PermanentStorage();
    }

    /**
     * Checking that similarity text already contains in the database.
     * @param text for checking.
     * @return true if text more that 45% similarity.
     */
    public boolean haveSimilarVacancy(String text) {
        boolean haveSimilar = false;
        storage.connectToParserDB();
        try {
            ResultSet savedVacancies = storage.executeQuery("SELECT description FROM jobs");
            while (savedVacancies.next()) {
                String description = savedVacancies.getString("description");
                double percentage = StringUtils.getJaroWinklerDistance(text, description) * 100;

                LOGGER.info(String.format("%.2f percentage between vacancies", percentage));
                if (Double.compare(percentage, 45.0d) > 0) {
                    haveSimilar = true;
                }
            }
        } catch (SQLException sql) {
            LOGGER.warning(sql.getMessage());
        }

        return haveSimilar;
    }
}
