package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShotPoolTest {
    private ShotPool shotPool;

    @Before
    public void setUp() {
        shotPool = new ShotPool();
    }

    @Test
    public void Test1() {
        shotPool.put(new Shot(new Position(0, 0), new Size(1, 1)));
        shotPool.put(new Shot(new Position(0, 1), new Size(1, 1)));
        shotPool.put(new Shot(new Position(0, 2), new Size(1, 1)));

        assertEquals(3, shotPool.getPool().size());

        shotPool.extract(Shot.class);
        shotPool.extract(Shot.class);
        shotPool.extract(Shot.class);

        assertEquals(0, shotPool.getPool().size());

        shotPool.put(new Shot(new Position(3, 3), new Size(1, 1)));
        Shot shot = shotPool.extract(Shot.class);
        assertEquals(0, shotPool.getPool().size());
        shotPool.put(shot);
        assertEquals(1, shotPool.getPool().size());
        shotPool.extract(Shot.class);
        assertEquals(0, shotPool.getPool().size());
    }
}
