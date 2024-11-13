package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {


//        RectangularMap map = new RectangularMap(5,5);
//        List<MoveDirection> directions = OptionsParser.parse(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        Simulation simulation = new Simulation(positions, directions, map);
//        simulation.run();


        List<String> text = List.of("Ala","ma","sowoniedzwiedzia");
        ArrayList<String> text2 = new ArrayList<>(text);
        TextMap map = new TextMap(text2);
        System.out.println(map);
        map.move("ma", MoveDirection.RIGHT);
        System.out.println(map);
        map.move("ma",MoveDirection.FORWARD);
        System.out.println(map);
        map.move("Ala", MoveDirection.RIGHT);
        System.out.println(map);
    }
}
