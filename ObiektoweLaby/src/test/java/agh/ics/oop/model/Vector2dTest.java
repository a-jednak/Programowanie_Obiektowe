package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Vector2dTest {

    @Test
    void equalsTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(1,-2);
        MapDirection vectorFake = MapDirection.WEST;

        //then
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(vectorFake));
    }

    @Test
    void toStringTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);

        //when
        String sv1 = v1.toString();

        //then
        assertEquals("(1, 2)", sv1);
    }

    @Test
    void precedesTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //then
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }

    @Test
    void followsTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //then
        assertFalse(v1.follows(v2));
        assertTrue(v2.follows(v1));
    }

    @Test
    void upperRightTest(){
        //given
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.upperRight(v2);

        //then
        assertEquals(new Vector2d(3,5), v3);
    }

    @Test
    void lowerLeftTest(){
        //given
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.lowerLeft(v2);

        //then
        assertEquals(new Vector2d(1,4), v3);
    }

    @Test
    void addTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.add(v2);

        //then
        assertEquals(new Vector2d(4,6), v3);
    }

    @Test
    void subtractTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);

        //when
        Vector2d v3 = v1.subtract(v2);
        Vector2d v4 = v2.subtract(v1);

        //then
        assertEquals(new Vector2d(-2,-2), v3);
        assertEquals(new Vector2d(2,2), v4);
    }

    @Test
    void oppositeTest(){
        //given
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(-3,4);

        //when
        Vector2d v3 = v1.opposite();
        Vector2d v4 = v2.opposite();

        //then
        assertEquals(new Vector2d(-1,-2),v3);
        assertEquals(new Vector2d(3,-4), v4);
    }
  
}