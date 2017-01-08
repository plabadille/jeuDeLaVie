/**
 * An object to use Direction.
 * @author Pierre Labadille, Alexandre Ducreux
 * @since 2017-01-07
 */

package model.fish;

public enum Direction {
    //direction constants
    TOP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    TOP_LEFT(-1, 1),
    TOP_RIGHT(1, 1),
    DOWN_LEFT(-1, -1),
    DOWN_RIGHT(1, -1);

    private int directionX;
    private int directionY;

    Direction(int directionX, int directionY) {
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public static Direction getTOP() {
        return TOP;
    }

    public static Direction getDOWN() {
        return DOWN;
    }

    public static Direction getLEFT() {
        return LEFT;
    }

    public static Direction getRIGHT() {
        return RIGHT;
    }

    public static Direction getTOP_LEFT() {
        return TOP_LEFT;
    }

    public static Direction getTOP_RIGHT() {
        return TOP_RIGHT;
    }

    public static Direction getDOWN_LEFT() {
        return DOWN_LEFT;
    }

    public static Direction getDOWN_RIGHT() {
        return DOWN_RIGHT;
    }

    public int getDirectionX() {
        return directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

}
