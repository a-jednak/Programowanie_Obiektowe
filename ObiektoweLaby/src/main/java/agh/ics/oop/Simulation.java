package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals;
    private final List<MoveDirection> directions;

    public Simulation(List<Vector2d> startingPoints, List<MoveDirection> directions) {
        this.directions = directions;
        this.animals = new ArrayList<>();
        for (Vector2d position : startingPoints) {
            this.animals.add(new Animal(position));
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() {
        int allAnimals = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            animals.get( i % allAnimals ).move(directions.get(i));
            System.out.printf(("Zwierzak %d - %s%n"), i%allAnimals, animals.get(i%allAnimals));
        }
    }
}