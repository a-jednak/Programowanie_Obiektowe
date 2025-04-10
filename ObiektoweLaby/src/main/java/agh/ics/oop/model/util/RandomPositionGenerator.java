package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomPositionGenerator implements Iterable<Vector2d> {

    private final List<Vector2d> positions = new ArrayList<Vector2d>();
    private final int size;

    public RandomPositionGenerator(double maxX, double maxY, int size) {
        for (int i = 0; i <= maxX; i++) {
            for (int j = 0; j <= maxY; j++) {
                positions.add(new Vector2d(i, j));
            }
        }
        this.size = size;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return new RandomPositionGeneratorIterator(size, this);
    }

    public List<Vector2d> getPositions() {
        return positions;
    }
}

class RandomPositionGeneratorIterator implements Iterator<Vector2d> {
    private final int size;
    private int index = 0;
    RandomPositionGenerator rpg;

    RandomPositionGeneratorIterator(int size, RandomPositionGenerator rpg) {
        this.size = size;
        this.rpg = rpg;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Vector2d next() {
        index++;
        Collections.shuffle(rpg.getPositions());
        Vector2d res = rpg.getPositions().getLast();
        rpg.getPositions().remove(res);
        return res;
    }
}
