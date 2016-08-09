package model;

import java.util.Map;

/**
 * All template makers must implement this interface.
 */
public interface Template {

    String generate(String string, Map<String, String> values);
}
