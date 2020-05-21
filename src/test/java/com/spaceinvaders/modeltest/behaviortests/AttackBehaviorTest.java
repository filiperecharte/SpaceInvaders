package com.spaceinvaders.modeltest.behaviortests;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.AttackBehavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AttackBehaviorTest {
    private AttackBehavior attackBehavior;

    @Before
    public void setUp() {
        try {
            attackBehavior = new AttackBehavior(15);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest() throws IllegalArgumentException {
        new AttackBehavior(-1);
    }

    @Test
    public void readyToShootTest() {
        assertTrue(attackBehavior.readyToShoot(15));
        assertFalse(attackBehavior.readyToShoot(14));
    }
}
