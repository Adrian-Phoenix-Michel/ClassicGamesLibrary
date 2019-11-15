package sample;

public class SnakeCoordinate {
    private final int x;
    private final int y;

    SnakeCoordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    SnakeCoordinate translate(int cx, int cy) {
        return new SnakeCoordinate(x + cx, y + cy);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SnakeCoordinate)) return false;
        SnakeCoordinate snakeCoordinate = (SnakeCoordinate) other;
        return x == snakeCoordinate.x & y == snakeCoordinate.y;
    }

    public String toString() {
        return x + ", " + y;
    }

    public void remove(int i) {
    }
}
