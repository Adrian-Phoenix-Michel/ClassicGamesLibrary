package sample;

import javafx.scene.paint.Color;

import java.util.Random;

class SnakeFoods {
    SnakeCoordinate snakeCoordinate = new SnakeCoordinate(10,10);
    static Color color;
    int point;

    public SnakeFoods(SnakeCoordinate snakeCoordinate, Color color, int point) {

    }

    public SnakeFoods(SnakeCoordinate randomCoordinate) {
    }
    // SnakeFoods[] foodColor = {new FoodUno(new SnakeCoordinate(0,0), new Color(0,0,0,0), 0), new FoodDos(null, null, 0), new FoodTres(null, null, 0)};

    public SnakeCoordinate getSnakeCoordinate() {
        return snakeCoordinate;
    }

    public void setSnakeCoordinate(SnakeCoordinate snakeCoordinate) {
        this.snakeCoordinate = snakeCoordinate;
    }

   /* public SnakeFoods randomFood() {
        Random random = new Random();

        return foodColor[random.nextInt(3)];
    }*/
}
