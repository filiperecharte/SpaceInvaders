package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    @Test (expected = IllegalArgumentException.class)
    public void constructorExceptionTest() throws IllegalArgumentException {
        new Enemy(new Position(0, 0), new Size(4, 1), new Vector(1, 0));
    }

    @Test
    public void getShootPositionTest() {

        Enemy enemy = null;
        try {
            enemy = new Enemy(new Position(15, 20), new Size(3, 1), new Vector(1, 0));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        assert enemy != null;
        assertEquals(16,  enemy.getShootPosition().getX());
        assertEquals(20, enemy.getShootPosition().getY());

    }
}
