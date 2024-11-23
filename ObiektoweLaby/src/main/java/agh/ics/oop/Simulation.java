package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<Vector2d> startingPoints, List<MoveDirection> directions, WorldMap map) {
        this.directions = directions;
        this.animals = new ArrayList<>();
        for (Vector2d position : startingPoints) {
            Animal animal = new Animal(position);
            try {
                if (map.place(animal)) {
                    this.animals.add(animal);
                }
            }
            catch (IncorrectPositionException e) {
                System.out.println(e.getMessage());
            }
        }
        this.map = map;
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public void run() {
        System.out.println(map);
        int animalCnt = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            map.move(animals.get(i%animalCnt), directions.get(i));
        }
    }
}