package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation<T,P> {

    private final List<T> animals;
    private final List<MoveDirection> directions;
    private final WorldMap<T,P> map;

    public Simulation(List<T> startingPoints, List<MoveDirection> directions, WorldMap<T,P> map) {
        this.directions = directions;
        this.animals = startingPoints;
        this.map = map;
    }

    public List<T> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public void run() {
        System.out.println(map);
        int animalCnt = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            map.move(animals.get(i%animalCnt), directions.get(i));
            System.out.println(map);
        }
    }
}