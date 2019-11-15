package sample;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class SnakeBody {
    static Color color;
    Color dead;
    SnakeGrid snakeGrid;
    int length = 1;
    boolean safe = true;
    List<SnakeCoordinate> coordinates;
    SnakeCoordinate head;
    int xVelocity = 1;
    int yVelocity = 1;

    public SnakeBody(SnakeGrid snakeGrid, SnakeCoordinate snakeCoordinate) {
    }

    private void growTo(SnakeCoordinate snakeCoordinate) {
        length++;
        checkAndAdd(snakeCoordinate);
    }

    private void shiftTo(SnakeCoordinate snakeCoordinate) {
        checkAndAdd(snakeCoordinate);
        snakeCoordinate.remove(0);
    }

    private void checkAndAdd(SnakeCoordinate snakeCoordinate) {
        snakeCoordinate = snakeGrid.wrap(snakeCoordinate);
        safe &= !coordinates.contains(snakeCoordinate);
        coordinates.add(snakeCoordinate);
        head = snakeCoordinate;
    }

    public List<SnakeCoordinate> getCoordinates() {
        return coordinates;
    }

    public boolean isSafe() {
        return safe || length == 1;
    }

    SnakeCoordinate getHead() {
        return head;
    }

    private boolean isStill() {
        return xVelocity == 0 & yVelocity == 0;
    }

    void move() {
        if (!isStill()) {
            shiftTo(head.translate(xVelocity = 1, yVelocity = 1));
        }
    }

    void extend() {
        if (!isStill()) {
            growTo(head.translate(xVelocity, yVelocity));
        }
    }

    void setUp() {
        if (yVelocity == 1 && length > 1) return;
        xVelocity = 0;
        yVelocity = -1;
    }

    void setDown() {
        if (yVelocity == -1 && length > 1) return;
        xVelocity = 0;
        yVelocity = 1;
    }

    void setLeft() {
        if (xVelocity == 1 && length > 1) return;
        xVelocity = -1;
        yVelocity = 0;
    }

    void setRight() {
        if (xVelocity == -1 && length > 1) return;
        xVelocity = 1;
        yVelocity = 0;
    }
}