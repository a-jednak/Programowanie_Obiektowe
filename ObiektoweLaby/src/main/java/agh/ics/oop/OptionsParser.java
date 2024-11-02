package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<MoveDirection>();
        for (String arg : args) {
            directions.add(switch (arg) {
                        case "f" -> MoveDirection.FORWARD;
                        case "b" -> MoveDirection.BACKWARD;
                        case "r" -> MoveDirection.RIGHT;
                        case "l" -> MoveDirection.LEFT;
                        default -> null;
                    }
            );
            directions.remove(null);
        }
        return directions;
    }
}
