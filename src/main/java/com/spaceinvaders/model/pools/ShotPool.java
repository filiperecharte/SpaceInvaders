package com.spaceinvaders.model.pools;

import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.shots.enemyshotvariants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShotPool {
    private List<Shot> pool;

    public ShotPool() {
        pool = new ArrayList<>();
    }

    public Shot extract(Object shotType) {

        Shot extractedShot = null;

        for (Iterator<Shot> shotIterator = pool.iterator(); shotIterator.hasNext();) {
            Shot shot = shotIterator.next();
            if (shot.getClass().equals(shotType)) {
                extractedShot = shot;
                shotIterator.remove();
                break;
            }
        }

        return extractedShot;
    }

    public void put(Shot shot) {
        pool.add(shot);
    }

    public List<Shot> getPool() {
        return pool;
    }

    public void setPool(List<Shot> pool) {
        this.pool = pool;
    }
}
