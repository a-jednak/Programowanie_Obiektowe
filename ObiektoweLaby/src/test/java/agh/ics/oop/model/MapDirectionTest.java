package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void nextTest(){
        //given
        MapDirection n = MapDirection.NORTH;
        MapDirection e = MapDirection.EAST;
        MapDirection s = MapDirection.SOUTH;
        MapDirection w = MapDirection.WEST;

        //when
        MapDirection nextN = n.next();
        MapDirection nextE = e.next();
        MapDirection nextS = s.next();
        MapDirection nextW = w.next();

        //then
        assertEquals(MapDirection.EAST, nextN);
        assertEquals(MapDirection.SOUTH, nextE);
        assertEquals(MapDirection.WEST, nextS);
        assertEquals(MapDirection.NORTH, nextW);
    }

    @Test
    void previousTest(){    //chyba ładniejsze w tym wypadku?
        for(MapDirection direction : MapDirection.values()) {
            MapDirection previousDirection = direction.previous();
            switch (direction) {
                case NORTH -> assertEquals(MapDirection.WEST, previousDirection);
                case EAST -> assertEquals(MapDirection.NORTH, previousDirection);
                case SOUTH -> assertEquals(MapDirection.EAST, previousDirection);
                case WEST -> assertEquals(MapDirection.SOUTH, previousDirection);
            }
        }
    }
}