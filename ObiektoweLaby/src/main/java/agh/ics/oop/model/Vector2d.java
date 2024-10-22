package agh.ics.oop.model;

public class Vector2d {
    private final int x;
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    boolean precedes(Vector2d other) {
        return other.getX() >= getX() && other.getY() >= getY();
    }

    boolean follows(Vector2d other) {
        return other.getX() <= getX() && other.getY() <= getY();
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(x + other.getX(), y + other.getY());
    }

    Vector2d subtract(Vector2d other) {
        return new Vector2d(x - other.getX(), y - other.getY());
    }

    Vector2d upperRight(Vector2d other) {
        int y = Math.max(other.getY(), getY());
        int x = Math.max(other.getX(), getX());
        return new Vector2d(x, y);
    }

    Vector2d lowerLeft(Vector2d other) {
        int y = Math.min(other.getY(), getY());
        int x = Math.min(other.getX(), getX());
        return new Vector2d(x, y);
    }

    Vector2d opposite() {
        int x = getX();
        int y = getY();
        return new Vector2d(-x, -y);
    }

    public boolean equals(Object other) {
        if(other instanceof Vector2d) {
            return ((Vector2d) other).getX() == getX() && ((Vector2d) other).getY() == getY();
        }
        return false;
    }
}
