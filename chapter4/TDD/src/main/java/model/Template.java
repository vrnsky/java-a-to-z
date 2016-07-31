package model;

/**
 * All template makers must implement this interface.
 */
public interface Template {

    String generate(String string, Object[] data);
}
