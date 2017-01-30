package models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.01.2017
 * Find all squares of islands.
 */
public class Square {

    /**
     * Field with islands and ocean.
     */
    private final int[][] values;

    /**
     * Default constructor.
     * @param values field.
     */
    public Square(final int[][] values) {
        this.values = values;
    }

    /**
     * Searches first one at the field and start search neibor ones.
     * @return list of all squares.
     */
    public List<Integer> findOne() {
        List<Integer> squares = new ArrayList<>(100);
        for (int index = 0; index < values.length; index++) {
            for (int barrier = 0; barrier < values[index].length; barrier++) {
                if (this.values[index][barrier] == 1) {
                    List<Point> points = findFullSquare(index, barrier);
                    squares.add(points.size());
                    setToZero(index, barrier, points);
                }
            }
        }
        return squares;
    }

    /**
     * clear field from already counted islands.
     * @param index x start of island.
     * @param barrier y start of island.
     * @param points all points of island.
     */
    private void setToZero(int index, int barrier, List<Point> points) {
        this.values[index][barrier] = 0;
        for (Point point : points) {
            this.values[point.getX()][point.getY()] = 0;
        }
    }

    /**
     * Find all square of island.
     * @param index start x of island.
     * @param barrier start y of island.
     * @return list of point which is island.
     */
    private List<Point> findFullSquare(int index, int barrier) {
        List<Point> points = new ArrayList<>();
        for (int x = 0; x < values.length; x++) {
            for (int y = 0; y < values[index].length; y++) {
                if (isCorrectNear(index, barrier, x, y) && this.values[x][y] == 1) {
                    points.add(new Point(x, y));
                }
            }
        }
        return points;
    }

    /**
     * Check that given point correct neibor.
     * @param oneX x point of start checking.
     * @param oneY y point of start checking.
     * @param twoX neibor point for checking.
     * @param twoY neibor point for checking.
     * @return true if good neibor.
     */
    private boolean isCorrectNear(int oneX, int oneY, int twoX, int twoY) {
        boolean result = false;
        if (Math.abs(twoX - oneX) >= 0 && oneY == twoY) {
            result = true;
        } else if (Math.abs(twoY - oneY) >= 0 && oneX == twoX) {
            result = true;
        }
        return result;
    }

    /**
     * Describe point at the field.
     */
    private static class Point {

        /**
         * X position.
         */
        private int x;

        /**
         * y position.
         */
        private int y;

        /**
         * Default constuctor.
         * @param x position of point.
         * @param y position of point.
         */
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Get x of this point.
         * @return x of this point.
         */
        public int getX() {
            return this.x;
        }

        /**
         * Get y of this point.
         * @return y of this point.
         */
        public int getY() {
            return this.y;
        }
    }
}
