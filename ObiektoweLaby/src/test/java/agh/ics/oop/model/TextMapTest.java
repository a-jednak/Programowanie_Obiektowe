package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void placeTest(){
        //given
        List<String> text = List.of("Ala","ma","sowoniedzwiedzia");
        ArrayList<String> text2 = new ArrayList<>(text);
        TextMap map = new TextMap(text2);
        String s = "?";

        //when
        map.place(s);
        ArrayList<String> text3 = map.getText();

        //then
        assertEquals("?",text3.getLast());
    }

    @Test
    void moveTest() {
        //given
        List<String> text = List.of("Ala","ma","sowoniedzwiedzia");
        ArrayList<String> text2 = new ArrayList<>(text);
        TextMap map = new TextMap(text2);

        //when
        map.move("Ala", MoveDirection.RIGHT);
        map.move("sowoniedzwiedzia", MoveDirection.BACKWARD);
        map.move("Ala", MoveDirection.FORWARD); //out of bounds

        //then
        assertEquals("[ma, sowoniedzwiedzia, Ala]", map.toString());
    }

    @Test
    void objectAtTest() {
        //given
        List<String> text = List.of("Ala","ma","sowoniedzwiedzia");
        ArrayList<String> text2 = new ArrayList<>(text);
        TextMap map = new TextMap(text2);

        //when
        String s1 = map.objectAt(1);
        String s2 = map.objectAt(3);

        //then
        assertEquals("ma", s1);
        assertNull(s2);
    }

}