package agh.ics.oop.model;

public class Animal {

    private MapDirection currentDirection;
    private Vector2d location;

    public Animal() {
        this(new Vector2d(2,2));
    }

    public Animal(Vector2d location) {
        this.location = location;
        this.currentDirection = MapDirection.NORTH;
    }

    public MapDirection getCurrentDirection() {
        return currentDirection;
    }

    public Vector2d getLocation() {
        return location;
    }

    public String toString() {
        return "(%d, %d), %s".formatted(location.getX(), location.getY(), currentDirection);
    }

    public boolean isAt(Vector2d position) {
        return location.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> currentDirection = currentDirection.next();
            case LEFT -> currentDirection = currentDirection.previous();
            case FORWARD, BACKWARD -> actualMove(direction);
        }
    }

    private void actualMove(MoveDirection direction) {
        Vector2d v = currentDirection.toUnitVector();
        if (direction.equals(MoveDirection.FORWARD)) {
            location = location.add(v);
            if(outOfBounds(location)) {
                location = location.subtract(v);
            }
        }
        else {
            location = location.subtract(v);
            if(outOfBounds(location)) {
                location = location.add(v);
            }
        }
    }

    private boolean outOfBounds(Vector2d position) {
        return position.getX() > 4 || position.getX() < 0 || position.getY() > 4 || position.getY() < 0;
    }
}
