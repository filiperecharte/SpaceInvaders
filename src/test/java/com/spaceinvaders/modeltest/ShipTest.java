package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ShipTest {

    private Image imageMock1;
    private Image imageMock2;

    @Before
    public void setUp() {
        imageMock1 = Mockito.mock(Image.class);
        when(imageMock1.getSize()).thenReturn(new Size(7, 1));

        imageMock2 = Mockito.mock(Image.class);
        when(imageMock2.getSize()).thenReturn(new Size(6, 1));
    }

    @Test
    public void getShootPositionTest() {
        Ship ship = null;

        try {
            ship = new Ship(new Position(10, 3), new Size(7, 1), imageMock1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        assert ship != null;
        assertEquals(13, ship.getShootPosition().getX());
        assertEquals(3, ship.getShootPosition().getY());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalArgumentTest1() throws IllegalArgumentException {
        Ship ship = new Ship(new Position(10, 3), new Size(9, 1), imageMock1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalArgumentTest2() throws IllegalArgumentException {
        Ship ship = new Ship(new Position(10, 3), new Size(6, 1), imageMock2);
    }
}
