package sample;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

class BodyUno extends SnakeBody {

    BodyUno(SnakeGrid snakeGrid, SnakeCoordinate initialCoordinate) {
        super(snakeGrid, initialCoordinate);
        color = Color.LIGHTBLUE;
        dead = Color.DARKRED;
        length = 1;
        coordinates = new LinkedList<>();
        coordinates.add(initialCoordinate);
        head = initialCoordinate;
        safe = true;
        this.snakeGrid = snakeGrid;
        xVelocity = 1;
        yVelocity = 1;
    }

    /*

    void setUp() {
        if (yVelocity == 1 && length > 1) return;
        xVelocity = 0;
        yVelocity = 1;
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

    */
}
