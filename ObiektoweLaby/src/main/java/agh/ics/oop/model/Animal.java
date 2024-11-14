package agh.ics.oop.model;

public class Animal {

    public static final Vector2d MIN_BOUNDARY = new Vector2d(0,0);
    public static final Vector2d MAX_BOUNDARY = new Vector2d(4,4);

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
        return "%s".formatted(currentDirection);
    }

    public boolean isAt(Vector2d position) {
        return location.equals(position);
    }

    public void move(MoveDirection direction, RectangularMap map) {
        switch (direction) {
            case RIGHT -> currentDirection = currentDirection.next();
            case LEFT -> currentDirection = currentDirection.previous();
            case FORWARD, BACKWARD -> actualMove(direction, map);
        }
    }

    private void actualMove(MoveDirection direction, RectangularMap map) {
        Vector2d v;
        if (direction.equals(MoveDirection.FORWARD)) {
            v = location.add(currentDirection.toUnitVector());
        }
        else {
            v = location.subtract(currentDirection.toUnitVector());
        }
        if(map.canMoveTo(v)) {
            location = v;
        }
    }
}
