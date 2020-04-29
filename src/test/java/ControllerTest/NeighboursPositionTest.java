package ControllerTest;

import Controller.NeighboursPosition;
import Model.Position;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class NeighboursPositionTest {
    private Position mockPosition;

    @Before
    public void setUp() {
        mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(10);
        when(mockPosition.getY()).thenReturn(20);
    }

    @Test
    public void neighboursPositionTestPositionOnly() {
        NeighboursPosition neighboursPosition = new NeighboursPosition(mockPosition);

        assertEquals(9, neighboursPosition.left().getX());
        assertEquals(20, neighboursPosition.left().getY());

        assertEquals(11, neighboursPosition.right().getX());
        assertEquals(20, neighboursPosition.right().getY());

        assertEquals(10, neighboursPosition.up().getX());
        assertEquals(19, neighboursPosition.up().getY());

        assertEquals(10, neighboursPosition.down().getX());
        assertEquals(21, neighboursPosition.down().getY());
    }

    @Test
    public void neighboursPositionTestPositionRange() {
        NeighboursPosition neighboursPosition = new NeighboursPosition(mockPosition, 4);

        assertEquals(6, neighboursPosition.left().getX());
        assertEquals(20, neighboursPosition.left().getY());

        assertEquals(14, neighboursPosition.right().getX());
        assertEquals(20, neighboursPosition.right().getY());

        assertEquals(10, neighboursPosition.up().getX());
        assertEquals(16, neighboursPosition.up().getY());

        assertEquals(10, neighboursPosition.down().getX());
        assertEquals(24, neighboursPosition.down().getY());
    }
}
