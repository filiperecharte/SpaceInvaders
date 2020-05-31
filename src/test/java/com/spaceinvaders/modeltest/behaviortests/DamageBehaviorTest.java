package com.spaceinvaders.modeltest.behaviortests;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DamageBehaviorTest {
    private DamageBehavior damageBehavior;
    private HealthyBehavior healthyBehavior;

    @Before
    public void setUp() {
        try {
            damageBehavior = new DamageBehavior(2);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }

        try {
            healthyBehavior = new HealthyBehavior(5);
        } catch (IllegalArgumentException e) { e.printStackTrace(); }
    }

    @Test
    public void applyDamageTest() {
        assertEquals(5, healthyBehavior.getCurrentHealth());
        assertFalse(healthyBehavior.isDead());
        damageBehavior.applyDamage(healthyBehavior);
        assertEquals(3, healthyBehavior.getCurrentHealth());
        assertFalse(healthyBehavior.isDead());
        damageBehavior.applyDamage(healthyBehavior);
        assertEquals(1, healthyBehavior.getCurrentHealth());
        assertFalse(healthyBehavior.isDead());
        damageBehavior.applyDamage(healthyBehavior);
        assertEquals(-1, healthyBehavior.getCurrentHealth());
        assertTrue(healthyBehavior.isDead());
    }
}
