package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {

    public static void main(String[] args) {

//        Animal animal = new Animal();
//        System.out.println(animal.getLocation());

        RectangularMap map = new RectangularMap(5,5);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
    }

    public static void run(List<MoveDirection> args) {

        for(MoveDirection arg : args) {
            switch (arg) {
                case MoveDirection.FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case MoveDirection.BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case MoveDirection.RIGHT -> System.out.println("Zwierzak skreca w prawo");
                case MoveDirection.LEFT -> System.out.println("Zwierzak skreca w lewo");
            }
        }

    }

}
