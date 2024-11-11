package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void runSimulationTest() {
        //given
        List<Vector2d> positions = new ArrayList<>();
        positions.add(new Vector2d(0,0));

        String[] moves = {"f", "x", "r", "b", "l", "f"};
        List<MoveDirection> directions = OptionsParser.parse(moves);

        //when
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
        List<Animal> animals = simulation.getAnimals();
        Animal animal = animals.getFirst();

        //then
        assertEquals(MapDirection.NORTH, animal.getCurrentDirection());
        assertEquals(new Vector2d(0,2), animal.getLocation());
        assertTrue(animal.getLocation().follows(new Vector2d(0,0)));
        assertTrue(animal.getLocation().precedes(new Vector2d(4,4)));
    }

}