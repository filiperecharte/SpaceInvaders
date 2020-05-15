package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class EnemyTest {
    private Image imageMock;

    @Before
    public void setUp() {
        imageMock = Mockito.mock(Image.class);
        when(imageMock.getSize()).thenReturn(new Size(7, 1));

    }

    @Test
    public void updateTest() {
        Enemy enemy = null;
        try {
            enemy = new Enemy(new Position(10, 3), new Size(7, 1), imageMock);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        assert enemy != null;
        enemy.update();

        assertEquals(11, enemy.getPosition().getX());
        assertEquals(3, enemy.getPosition().getY());

        enemy.setDirection(-1);
        enemy.update();

        assertEquals(10, enemy.getPosition().getX());
        assertEquals(3, enemy.getPosition().getY());

    }
}
