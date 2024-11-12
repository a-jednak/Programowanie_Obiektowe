package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void placeTest() {
        //given
        RectangularMap map = new RectangularMap(3,3);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(5,2));
        Animal animal3 = new Animal();

        //then
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertFalse(map.place(animal3));
    }

    @Test
    void moveTest() {
        //given
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,3));

        //when
        map.place(animal1);
        map.place(animal2);
        map.move(animal1, MoveDirection.FORWARD);
        map.move(animal2, MoveDirection.RIGHT);
        map.move(animal2, MoveDirection.FORWARD);

        //then
        assertEquals(new Vector2d(2,2), animal1.getLocation());
        assertEquals(new Vector2d(3,3), animal2.getLocation());
    }

    @Test
    void isOccupiedTest() {
        //given
        RectangularMap map = new RectangularMap(6,6);
        Animal animal1 = new Animal(new Vector2d(3,5));
        Animal animal2 = new Animal(new Vector2d(1,7));

        //when
        map.place(animal1);
        map.place(animal2);

        //then
        assertFalse(map.isOccupied(new Vector2d(1,7)));
        assertTrue(map.isOccupied(new Vector2d(3,5)));
    }

    @Test
    void objectAtTest() {
        //given
        RectangularMap map = new RectangularMap(6,6);
        Animal animal1 = new Animal(new Vector2d(3,5));
        Animal animal2 = new Animal();

        //when
        map.place(animal1);
        map.place(animal2);

        //then
        assertEquals(animal1, map.objectAt(new Vector2d(3,5)));
        assertEquals(animal2, map.objectAt(new Vector2d(2,2)));
    }

    @Test
    void canMoveToTest() {
        //given
        RectangularMap map = new RectangularMap(3,3);
        Animal animal = new Animal();

        //when
        map.place(animal);

        //then
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(1,2)));
        assertFalse(map.canMoveTo(new Vector2d(4,1)));
    }


}