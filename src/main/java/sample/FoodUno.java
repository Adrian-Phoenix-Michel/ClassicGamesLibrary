package sample;

import javafx.scene.paint.Color;

public class FoodUno extends SnakeFoods {
    final Color color = Color.RED;

    FoodUno(SnakeCoordinate snakeCoordinate, Color color, int point) {
        super(snakeCoordinate, color, point);
        this.snakeCoordinate = snakeCoordinate;
        this.point = 1;
    }
}
