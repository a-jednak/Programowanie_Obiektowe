package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;
import java.util.Objects;

public class World {

    public static void main(String[] args) {

        System.out.println("System wystartowal");

        run(OptionsParser.metoda(args));

        System.out.println("System zakonczyl dzialanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());
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
