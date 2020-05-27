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

        if (pool.isEmpty() || extractedShot==null){
            if (shotType.getClass().equals(PowerfulShot.class)){
                return new PowerfulShot();
            }
            else if (shotType.getClass().equals(WeakShot.class)){
                return new WeakShot();
            }
            else if (shotType.getClass().equals(LegendaryShot.class)){
                return new LegendaryShot();
            }
            else if (shotType.getClass().equals(SlickShot.class)){
                return new SlickShot();
            }
            else if (shotType.getClass().equals(ImmatureShot.class)){
                return new ImmatureShot();
            }
        }

        return extractedShot;
    }

    public void put(Shot shot) {
        pool.add(shot);
    }
}
