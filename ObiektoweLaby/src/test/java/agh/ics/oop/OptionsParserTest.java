package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.moves;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void movesTest(){
        //given
        String[] directions = {"f", "r", "X", "l", "X", "b"};

        List<MoveDirection> correct = new ArrayList<MoveDirection>();
        correct.add(MoveDirection.FORWARD);
        correct.add(MoveDirection.RIGHT);
        correct.add(MoveDirection.LEFT);
        correct.add(MoveDirection.BACKWARD);

        //when
        List<MoveDirection> goodDirections = moves(directions);

        //then
        assertEquals(correct, goodDirections);
    }

}