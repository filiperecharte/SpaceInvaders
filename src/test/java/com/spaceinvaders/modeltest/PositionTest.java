package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void PositionAddTest() {
        Position position = new Position(3,4);

        assertEquals(8, position.add(new Position(5,5)).getX());
        assertEquals(9,position.add(new Position(5,5)).getY());

    }

    @Test
    public void PositionSubTest() {
        Position position = new Position(3,4);

        assertEquals(1, position.sub(new Position(2,4)).getX());
        assertEquals(0,position.sub(new Position(2,4)).getY());
    }

    @Test
    public void PositionEqualsTest() {
        Position position = new Position(3,4);

        assertEquals(position, new Position(3, 4));
        assertNotEquals(position, new Position(2, 4));
        assertNotEquals(position, new Position(3, 2));
    }

}
