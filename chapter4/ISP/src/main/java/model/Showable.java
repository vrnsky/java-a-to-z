package model;

import start.IO;

/**
 * Show data across IO interface.
 */
public interface Showable {

    /**
     * Show something value across io.
     * @param value instance for showing.
     * @param io system for showing.
     */
    void show(String value, IO io);
}
