package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int grassSpots) {
        for(int i = 0; i<grassSpots; i++){
            int x = (int) (Math.random() * (sqrt(grassSpots*10)));
            int y = (int) (Math.random() * (sqrt(grassSpots*10)));

            Vector2d v = new Vector2d(x, y);
            Grass newGrass = new Grass(v);
            if(!this.grass.containsKey(v)){
                this.grass.put(v, newGrass);
                this.upperRight = v;
                this.lowerLeft = v;
            }
            else{
                i--;
            }
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
