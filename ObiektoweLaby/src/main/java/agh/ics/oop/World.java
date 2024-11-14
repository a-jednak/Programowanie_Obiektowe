package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) {

        GrassField map = new GrassField(10);
//        RectangularMap map = new RectangularMap(5,5);
        String[] moves = {"f","r","b","f","b","f","b","f","b","f","b","f","b","f","b","f"};
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

    }
}
