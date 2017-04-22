package ru.vrnsky.sony;

import ru.vrnsky.interfaces.Body;

/**
 * @author vrnsky.
 * @version 0.1
 *
 * This is implementation of toshiba body.
 */
public class ToshibaBody implements Body {

    /**
     * Turn body.
     */
    @Override
    public void turn() {
        System.out.println("Body was turn!");
    }
}
