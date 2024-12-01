package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.RandomPositionGenerator;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static void main(String[] args) throws InterruptedException {

        String[] moves = {"f","r","b","f","f","b"};
        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(4,3));
        List<Simulation> simulations = new ArrayList<>();

        for(int i =0; i<1000; i++) {
            int x = (int)(Math.random()*10);
            GrassField map = new GrassField(x);
            map.addObserver(new ConsoleMapDisplay());
            Simulation simulation = new Simulation(positions, directions, map);
            simulations.add(simulation);
        }
        SimulationEngine engine = new SimulationEngine(simulations);
//        engine.runSync();
//        engine.runAsync();
        engine.runAsyncInThreadPool();

        System.out.println("System zakonczyl dzialanie");

    }
}
