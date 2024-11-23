package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d upperRight;
    protected Vector2d lowerLeft;

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d prevPos = animal.getPosition();
        animal.move(direction, this);
        animals.remove(prevPos);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> elements = new HashMap<>();
         for(Map.Entry<Vector2d, Animal> entry : animals.entrySet()) {
             Vector2d position = entry.getKey();
             Animal animal = entry.getValue();
             elements.put(position, animal);
         }
         return elements;
    }

}
