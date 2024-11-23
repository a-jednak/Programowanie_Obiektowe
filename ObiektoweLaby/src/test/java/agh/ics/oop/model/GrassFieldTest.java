package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void placeTest() {
        //given
        GrassField field = new GrassField(3);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(10,10));
        Animal animal3 = new Animal();

        //then
        assertTrue(field.place(animal1));
        assertTrue(field.place(animal2));
        assertFalse(field.place(animal3));
    }

    @Test
    void moveTest() {
        //given
        GrassField field = new GrassField(3);
        Animal animal1 = new Animal();

        //when
        field.place(animal1);
        field.move(animal1, MoveDirection.BACKWARD);
        field.move(animal1, MoveDirection.BACKWARD);
        field.move(animal1, MoveDirection.BACKWARD);
        field.move(animal1, MoveDirection.RIGHT);

        //then
        assertEquals(new Vector2d(2,-1), animal1.getPosition());
        assertEquals(MapDirection.EAST, animal1.getCurrentDirection());
    }

    @Test
    void isOccupiedTest() {
        //given
        GrassField field = new GrassField(10);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(4,4));

        //when
        field.place(animal1);
        field.place(animal2);
        Map<Vector2d, Grass> grass = field.getGrass();

        //then
        for( Vector2d grassSpot : grass.keySet()){
            assertTrue(field.isOccupied(grassSpot));
        }
        assertTrue(field.isOccupied(new Vector2d(2,2)));
        assertTrue(field.isOccupied(new Vector2d(4,4)));
    }

    @Test
    void objectAtTest() {
        //given
        GrassField field = new GrassField(10);
        Animal animal1 = new Animal();

        //when
        field.place(animal1);
        Map<Vector2d, Grass> grass = field.getGrass();

        //then
        for( Vector2d grassSpot : grass.keySet()){
            if(field.objectAt(grassSpot) != animal1)
            {
                assertEquals(grass.get(grassSpot), field.objectAt(grassSpot));
            }
        }
        assertEquals(animal1, field.objectAt(new Vector2d(2,2)));
    }

}