package sample;

import com.sun.org.apache.xml.internal.security.c14n.CanonicalizerSpi;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import sample.SnakeLoop;
import sample.SnakeGrid;
import sample.SnakeBody;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

public class LibraryMain extends Application {

    private Scene scene3;
    private boolean sceneTo3 = false;

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
/*
        primaryStage.setTitle("ClassicsGameLibrary");

        FXMLLoader fxmlLoader1 = new FXMLLoader(
                getClass().getResource("/Library.fxml"));
        Parent root1 = (Parent) fxmlLoader1.load();
        Scene scene1 = new Scene(root1);

        FXMLLoader fxmlLoader2 = new FXMLLoader(
                getClass().getResource("/Library.fxml"));
        Parent root2 = (Parent) fxmlLoader2.load();
        Scene scene2 = new Scene(root2);

        primaryStage.setScene(scene1);
        primaryStage.show();
        primaryStage.requestFocus();

        scene1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                primaryStage.setScene(scene2);
            }
        });

        scene2.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                sceneTo3 = true;
            }
        });

        if (sceneTo3) {
*/
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

            Scene scene3 = new Scene(root);

            primaryStage.setResizable(false);
            primaryStage.setTitle("ClassicsGameLibrary");
            primaryStage.setOnCloseRequest(e -> System.exit(0));
            primaryStage.setScene(scene3);
            primaryStage.show();
            reset();
/*
        }
*/
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
