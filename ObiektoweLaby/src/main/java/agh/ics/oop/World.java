package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.List;

public class World {

    public static void main(String[] args) {

        System.out.println("System wystartowal");

        run(OptionsParser.moves(args));

        System.out.println("System zakonczyl dzialanie");
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
