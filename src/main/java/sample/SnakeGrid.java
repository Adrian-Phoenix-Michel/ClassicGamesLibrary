package sample;

import javafx.scene.paint.Color;

import java.util.Random;

public class SnakeGrid {
    public static final int size = 25;
    public static final Color color = Color.DARKGREY;

    private final int cols;
    private final int rows;

    private SnakeBody snakeBody;
    private SnakeFoods snakeFoods;

    public SnakeGrid(final double width, final double height) {
        rows = (int) width / size;
        cols = (int) height / size;

        snakeBody = new SnakeBody(this, new SnakeCoordinate(rows / 2, cols / 2));

        snakeFoods = new SnakeFoods(getRandomCoordinate());
    }

    public SnakeCoordinate wrap(SnakeCoordinate snakeCoordinate) {
        int x = snakeCoordinate.getX();
        int y = snakeCoordinate.getY();
        if (x >= rows) x = 0;
        if (y >= cols) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = cols - 1;
        return new SnakeCoordinate(x, y);
    }

    private SnakeCoordinate getRandomCoordinate() {
        Random random = new Random();
        SnakeCoordinate snakeCoordinate;
        do {
            snakeCoordinate = new SnakeCoordinate(random.nextInt(rows), random.nextInt(cols));
        } while (snakeCoordinate.equals(snakeBody.getHead()));
        return snakeCoordinate;
    }

    public void update() {
        if (snakeFoods.getSnakeCoordinate().equals(snakeBody.getHead())) {
            snakeBody.extend();
            snakeFoods.setSnakeCoordinate(getRandomCoordinate());
        } else {
            snakeBody.move();

        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public double getWidth() {
        return rows * size;
    }

    public double getHeight() {
        return cols * size;
    }

    public SnakeBody getSnakeBody() {
        return snakeBody;
    }

    public SnakeFoods getSnakeFoods() {
        return snakeFoods;
    }
}
