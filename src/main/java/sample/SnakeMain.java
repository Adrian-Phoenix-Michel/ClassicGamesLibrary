package sample;

import com.sun.org.apache.xml.internal.security.c14n.CanonicalizerSpi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.SnakeLoop;
import sample.SnakeGrid;
import sample.SnakeBody;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

public class SnakeMain extends Application {

    private static final int width = 500;
    private static final int height = 500;

    private SnakeLoop snakeLoop;
    private SnakeGrid snakeGrid;
    private SnakeDraw snakeDraw;
    private SnakeBody snakeBody;
    private SnakeCoordinate snakeCoordinate;
    private GraphicsContext graphicsContext;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            SnakeBody snakeBody = snakeGrid.getSnakeBody();
            if (snakeLoop.isKeyPressed()) {
                return;
            }
            switch (e.getCode()) {
                case W:
                    snakeBody.setUp();
                    break;
                case S:
                    snakeBody.setDown();
                    break;
                case A:
                    snakeBody.setLeft();
                    break;
                case D:
                    snakeBody.setRight();
                    break;
                case SPACE:
                    if (snakeLoop.isPaused()) {
                        reset();
                        (new Thread(snakeLoop)).start();
                    }
            }
        });

        reset();

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();
        reset();

        //(new Thread(snakeLoop)).start();


        /*Parent root = FXMLLoader.load(getClass().getResource("/Snake.fxml"));
        primaryStage.setTitle("Snake");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }

    private void reset() {
        snakeCoordinate = new SnakeCoordinate(width, height);
        snakeGrid = new SnakeGrid(width, height);
        snakeBody = new SnakeBody(snakeGrid, snakeCoordinate);
        snakeLoop = new SnakeLoop(snakeGrid, graphicsContext);
        SnakeDraw.draw(snakeGrid, graphicsContext);
    }


}
