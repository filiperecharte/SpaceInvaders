package com.spaceinvaders.modeltest.behaviortests;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import org.junit.Before;
import org.mockito.Mockito;

public class DamageBehaviorTest {
    private DamageBehavior damageBehavior;
    private HealthyBehavior healthyBehaviorMock;

    @Before
    public void setUp() {
        try {
            damageBehavior = new DamageBehavior(2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        healthyBehaviorMock = Mockito.mock(HealthyBehavior.class);
    }
}
