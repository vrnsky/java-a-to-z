package model;

import java.util.Random;

/**
 * @author evrnsky
 * @version 0.1
 * @since 06.12.2016
 * Describe direction of moving at the game.
 */
public enum Direction {

    /**
     * Up direction.
     */
    UP,

    /**
     * Down direction.
     */
    DOWN,

    /**
     * Left direction.
     */
    LEFT,

    /**
     * Right direction.
     */
    RIGHT;

    /**
     * Instance of RN. It generate pseudorandom numbers.
     */
    public static final Random RN = new Random();

    /**
     * Return RN direction.
     * @return RN direction.
     */
    public static Direction getRandomDirection() {
        int position = RN.nextInt(values().length);
        return values()[position];
    }
}
