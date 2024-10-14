package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static MoveDirection[] metoda(String[] args) {
        MoveDirection[] directions;
        int n = args.length;
        directions = new MoveDirection[n];
        int k = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> directions[k] = MoveDirection.FORWARD;
                case "b" -> directions[k] = MoveDirection.BACKWARD;
                case "r" -> directions[k] = MoveDirection.RIGHT;
                case "l" -> directions[k] = MoveDirection.LEFT;
                default -> k--; //rzyga jak daję coś innego?
            }
            k++;
        }
        return directions;
    }
}
