package model;

import java.util.Map;

/**
 * All template makers must implement this interface.
 */
public interface Template {

    /**
     * Generate new string filled by data from map.
     * @param string template for fill.
     * @param values for filling.
     * @return template filled by data from values.
     */
    String generate(String string, Map<String, String> values);
}
