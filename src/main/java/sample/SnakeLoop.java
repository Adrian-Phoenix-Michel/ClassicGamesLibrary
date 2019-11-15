package sample;

import javafx.scene.canvas.GraphicsContext;

public class SnakeLoop implements Runnable {
    private final SnakeGrid snakeGrid;
    SnakeBody snakeBody;
    private final GraphicsContext context;
    private int frameRate;
    private float interval;
    private boolean running;
    private boolean paused;
    private boolean keyIsPressed;
    boolean gamestart = false;

    public SnakeLoop(final SnakeGrid snakeGrid, final GraphicsContext context) {
        this.snakeGrid = snakeGrid;
        this.context = context;
        frameRate = 20;
        interval = 1000.0f / frameRate;
        running = true;
        paused = false;
        keyIsPressed = false;


    }

    @Override
    public void run() {
        while (running && !paused) {
            float time = System.currentTimeMillis();

            keyIsPressed = false;
            snakeGrid.update();
            SnakeDraw.draw(snakeGrid, context);

            if (!snakeGrid.getSnakeBody().isSafe()) {
                pause();
                SnakeDraw.drawResetMessage(context);
                break;
            }

            time = System.currentTimeMillis() - time;

            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                }
                catch (InterruptedException ignore) {
                }
            }
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isKeyPressed() {
        gamestart = true;
        return keyIsPressed;
    }

    public void setKeyPressed() {
        keyIsPressed = true;
    }

    public void resume() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }

    public boolean isPaused() {
        return paused;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }
}
