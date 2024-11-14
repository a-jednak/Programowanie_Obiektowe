package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void correctDirectionsTest() {
        //given
        RectangularMap map = new RectangularMap(3,3);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0,0));

        String[] moves = {"f", "f", "r", "f", "l", "b"};
        List<MoveDirection> directions = OptionsParser.parse(moves);

        //when
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        Animal animal = animals.getFirst();

        //then
        assertEquals(MapDirection.NORTH, animal.getCurrentDirection());
        assertEquals(new Vector2d(1,1), animal.getPosition());
    }

    @Test
    void animalsCollideTest() {
        //given
        RectangularMap map = new RectangularMap(3,3);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(1,0));
        positions.add(new Vector2d(1,1));

        String[] moves = {"f", "r", "f", "b"};
        List<MoveDirection> directions = OptionsParser.parse(moves);

        //when
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        Animal animal1 = animals.get(0);
        Animal animal2 = animals.get(1);

        //then
        assertEquals(MapDirection.NORTH, animal1.getCurrentDirection());
        assertEquals(new Vector2d(1,0), animal1.getPosition());

        assertEquals(MapDirection.EAST, animal2.getCurrentDirection());
        assertEquals(new Vector2d(0,1), animal2.getPosition());
    }

    @Test
    void incorrectDirectionsTest() {
        //given
        RectangularMap map = new RectangularMap(3,3);
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(1,1));
        String[] moves = {"f", "r", "x", "x", "b", "b", "y"};
        List<MoveDirection> directions = OptionsParser.parse(moves);

        //when
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        Animal animal = animals.getFirst();

        //then
        assertEquals(MapDirection.EAST, animal.getCurrentDirection());
        assertEquals(new Vector2d(0,2), animal.getPosition());
    }
}