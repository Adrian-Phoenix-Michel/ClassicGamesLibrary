package sample;

import sample.SnakeFoods;
import sample.SnakeGrid;
import sample.SnakeCoordinate;
import sample.SnakeBody;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static sample.SnakeGrid.size;

public class SnakeDraw {


    public static void draw(SnakeGrid snakeGrid, GraphicsContext graphicsContext) {
        graphicsContext.setFill(SnakeGrid.color);
        graphicsContext.fillRect(0, 0, snakeGrid.getWidth(), snakeGrid.getHeight());

        //FoodUno foodU = new FoodUno(null, null, 0);foodU.randomFood().color
        graphicsContext.setFill(SnakeFoods.color);
        drawSnakeCoordinate(snakeGrid.getSnakeFoods().getSnakeCoordinate(), graphicsContext);

        SnakeBody snakeBody = snakeGrid.getSnakeBody();
        graphicsContext.setFill(BodyUno.color);
        snakeBody.getCoordinates().forEach(snakeCoordinate -> drawSnakeCoordinate(snakeCoordinate, graphicsContext));
        if (!snakeBody.isSafe()) {
            graphicsContext.setFill(snakeBody.dead);
            drawSnakeCoordinate(snakeBody.getHead(), graphicsContext);
        }

        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillText("Score : " + 100 * snakeBody.getCoordinates().size(), 10,490);
    }

    private static void drawSnakeCoordinate(/*@org.jetbrains.annotations.NotNull*/ SnakeCoordinate snakeCoordinate, GraphicsContext graphicsContext) {
        graphicsContext.fillRect(snakeCoordinate.getX() * size, snakeCoordinate.getY() * size, size, size);
    }

    public static void drawResetMessage(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.ORANGERED);
        graphicsContext.fillText("Hit SPACE to reset!",10,10);
    }

}
