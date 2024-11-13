package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap<Animal, Vector2d> {

    private final Map<Vector2d, Animal> animals = new HashMap<>();

    private final int height;
    private final int width;
    private final Vector2d lowerLeft = new Vector2d(0, 0);
    private final Vector2d upperRight;

    private final MapVisualizer visualizer;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperRight = new Vector2d(this.width-1,this.height-1);
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getLocation())) {
            animals.put(animal.getLocation(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d prevLoc = animal.getLocation();
        animal.move(direction, this);
        animals.remove(prevLoc);
        animals.put(animal.getLocation(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }
}
