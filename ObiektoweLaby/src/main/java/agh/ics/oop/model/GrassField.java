package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int grassSpots) {
        double limit = sqrt(grassSpots*10);
        RandomPositionGenerator generator = new RandomPositionGenerator(limit,limit,grassSpots);
        for( Vector2d pos : generator) {
            this.grass.put(pos, new Grass(pos));
            this.upperRight = pos;
            this.lowerLeft = pos;
        }
    }

    public Map<Vector2d, Grass> getGrass() {
        return Collections.unmodifiableMap(grass);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(super.objectAt(position) != null){
            return super.objectAt(position);
        }
        return grass.get(position);
    }

    private void corners() {
        for(Vector2d position : animals.keySet()) {
            this.lowerLeft = position.lowerLeft(lowerLeft);
            this.upperRight = position.upperRight(upperRight);
        }
        for(Vector2d position : grass.keySet())
        {
            this.lowerLeft = position.lowerLeft(lowerLeft);
            this.upperRight = position.upperRight(upperRight);
        }
    }

    @Override
    public String toString() {
        corners();
        return super.toString();
    }

    @Override
    public Map<Vector2d, WorldElement> getElements() {
        Map<Vector2d, WorldElement> elements = super.getElements();
        for(Map.Entry<Vector2d, Grass> entry : grass.entrySet()) {
            Vector2d position = entry.getKey();
            Grass grass = entry.getValue();
            elements.put(position, grass);
        }
        return elements;
    }
}
