package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width-1,height-1);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && super.canMoveTo(position);
    }


}
