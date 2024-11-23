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
        }
    }

    public Map<Vector2d, Grass> getGrass() {
        return Collections.unmodifiableMap(grass);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement object = super.objectAt(position);
        if(object != null){
            return object;
        }
        return grass.get(position);
    }


    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grass.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(WorldElement element : getElements()) {
            lowerBound = lowerBound.lowerLeft(element.getPosition());
            upperBound = upperBound.upperRight(element.getPosition());
        }
        return new Boundary(lowerBound, upperBound);
    }
}
