package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest(){
        //given
        String[] directions1 = {"f", "r", "l", "b"};
        String[] directions2 = {};
        String[] directions3 = {"X", "f", "X","X"};

        List<MoveDirection> correct1 = new ArrayList<MoveDirection>();
        correct1.add(MoveDirection.FORWARD);
        correct1.add(MoveDirection.RIGHT);
        correct1.add(MoveDirection.LEFT);
        correct1.add(MoveDirection.BACKWARD);

        List<MoveDirection> correct2 = new ArrayList<MoveDirection>();

        List<MoveDirection> goodDirections1 = new ArrayList<>();
        List<MoveDirection> goodDirections2 = new ArrayList<>();
        List<MoveDirection> goodDirections3 = new ArrayList<>();

        //when
        try {
            goodDirections1 = parse(directions1);
            goodDirections2 = parse(directions2);
            goodDirections3 = parse(directions3);
            fail("Expected IllegalArgumentException not thrown");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //then
        assertEquals(correct1, goodDirections1);
        assertEquals(correct2, goodDirections2);
        assertEquals(correct2, goodDirections3);
    }

}