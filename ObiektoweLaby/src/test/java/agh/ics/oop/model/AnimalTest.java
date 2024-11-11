package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void toStringTest() {
        //given
        Animal animal = new Animal(new Vector2d(0,3));

        //when
        String s = animal.toString();

        //then
        assertEquals("(0, 3), Polnoc", s);
    }

    @Test
    void isAtTest() {
        //given
        Animal animal = new Animal(new Vector2d(0,3));

        //when
        boolean t = animal.isAt(new Vector2d(0,3));
        boolean f = animal.isAt(new Vector2d(1,2));

        //then
        assertTrue(t);
        assertFalse(f);
    }
}