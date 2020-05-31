package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Test;

public class ShipTest {

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest() throws IllegalArgumentException {
        Ship ship = new Ship(new Position(10, 3), new Size(6, 1), new HealthyBehavior(5));
    }

}
