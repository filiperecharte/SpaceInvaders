package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*public class ShipTest {

    @Test
    public void getShootPositionTest() {
        Ship ship = null;

        try {
            ship = new Ship(new Position(10, 3), new Size(7, 1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        assert ship != null;
        assertEquals(13, ship.getShootPosition().getX());
        assertEquals(3, ship.getShootPosition().getY());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest() throws IllegalArgumentException {
        Ship ship = new Ship(new Position(10, 3), new Size(6, 1));
    }
}*/
