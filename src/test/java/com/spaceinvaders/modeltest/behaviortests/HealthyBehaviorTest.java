package com.spaceinvaders.modeltest.behaviortests;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthyBehaviorTest {
    private HealthyBehavior healthyBehavior;

    @Before
    public void setUp() {
        try {
            healthyBehavior = new HealthyBehavior(3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest() throws IllegalArgumentException {
        new HealthyBehavior(-1);
    }

    @Test
    public void decrementTest() {
        assertEquals(3, healthyBehavior.getCurrentHealth());
        assertFalse(healthyBehavior.isDead());
        healthyBehavior.decrementHealth(2);
        assertEquals(1, healthyBehavior.getCurrentHealth());
        assertFalse(healthyBehavior.isDead());
        healthyBehavior.decrementHealth(3);
        assertEquals(-2, healthyBehavior.getCurrentHealth());
        assertTrue(healthyBehavior.isDead());
    }
}
