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
        String[] directions1 = {"f", "r", "X", "l", "X", "b"};
        String[] directions2 = {};
        String[] directions3 = {"X","X","X"};

        List<MoveDirection> correct1 = new ArrayList<MoveDirection>();
        correct1.add(MoveDirection.FORWARD);
        correct1.add(MoveDirection.RIGHT);
        correct1.add(MoveDirection.LEFT);
        correct1.add(MoveDirection.BACKWARD);

        List<MoveDirection> correct2 = new ArrayList<MoveDirection>();

        //when
        List<MoveDirection> goodDirections1 = parse(directions1);
        List<MoveDirection> goodDirections2 = parse(directions2);
        List<MoveDirection> goodDirections3 = parse(directions3);

        //then
        assertEquals(correct1, goodDirections1);
        assertEquals(correct2, goodDirections2);
        assertEquals(correct2, goodDirections3);
    }

}