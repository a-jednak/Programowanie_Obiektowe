package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<MoveDirection>();
        for (String arg : args) {
            directions.add(switch (arg) {
                        case "f", "forward" -> MoveDirection.FORWARD;
                        case "b", "backward" -> MoveDirection.BACKWARD;
                        case "r", "right" -> MoveDirection.RIGHT;
                        case "l", "left" -> MoveDirection.LEFT;
                        default -> throw new IllegalArgumentException(arg + " is not a legal move specification");
                    }
            );
        }
        return directions;
    }
}
