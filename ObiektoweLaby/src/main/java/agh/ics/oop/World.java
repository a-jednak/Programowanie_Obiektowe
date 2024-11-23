package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {

        GrassField map = new GrassField(10);
//        RectangularMap map = new RectangularMap(5,5);
        map.addObserver(new ConsoleMapDisplay());
        String[] moves = {"f","r","b","f","f","b"};
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,2));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

//        RandomPositionGenerator generator = new RandomPositionGenerator(2,2,8);
//        for( Vector2d pos : generator) {
//            System.out.println(pos);
//        }

    }
}
