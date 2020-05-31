package com.spaceinvaders.modeltest;

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
        shotPool.put(new Shot());
        shotPool.put(new Shot());
        shotPool.put(new Shot());

        assertEquals(3, shotPool.getPool().size());

        shotPool.extract();
        shotPool.extract();
        shotPool.extract();

        assertEquals(0, shotPool.getPool().size());

        shotPool.put(new Shot());
        Shot shot = shotPool.extract();
        assertEquals(0, shotPool.getPool().size());
        shotPool.put(shot);
        assertEquals(1, shotPool.getPool().size());
        shotPool.extract();
        assertEquals(0, shotPool.getPool().size());
    }
}
