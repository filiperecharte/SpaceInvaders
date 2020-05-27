package com.spaceinvaders.model.pools;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;
import com.spaceinvaders.model.pools.shotpools.enemyshotpools.*;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.shots.ShotsToPoolVisitor;

import java.util.ArrayList;
import java.util.List;

public class ShotPoolGroup {
    private ShipShotPool shipShotPool;
    private WeakShotPool weakShotPool;
    private ImmatureShotPool immatureShotPool;
    private SlickShotPool slickShotPool;
    private PowerfulShotPool powerfulShotPool;
    private LegendaryShotPool legendaryShotPool;
    List<ObjectPool<?>> pools;

    public ShotPoolGroup() {
        pools = new ArrayList<>();

        shipShotPool = new ShipShotPool();
        pools.add(shipShotPool);

        weakShotPool = new WeakShotPool();
        pools.add(weakShotPool);

        immatureShotPool = new ImmatureShotPool();
        pools.add(immatureShotPool);

        slickShotPool = new SlickShotPool();
        pools.add(slickShotPool);

        powerfulShotPool = new PowerfulShotPool();
        pools.add(powerfulShotPool);

        legendaryShotPool = new LegendaryShotPool();
        pools.add(legendaryShotPool);
    }

    /*public void put(IShotVisited shot) {
        shot.accept(new ShotsToPoolVisitor(this));
    }*/

    public void put(Object object) {
        for (ObjectPool<?> pool : pools) {
            if (pool.getObjectType().equals(object.getClass())) {
                //pool.put(object);
            }
        }
        //throw new IllegalArgumentException("Invalid object type");
    }

    public Object extract(Object type) throws IllegalArgumentException {
        for (ObjectPool<?> pool : pools) {
            if (pool.getObjectType().equals(type)) {
                return pool.extract();
            }
        }
        throw new IllegalArgumentException("Invalid object type");
    }

    public ShipShotPool getShipShotPool() {
        return shipShotPool;
    }

    public void setShipShotPool(ShipShotPool shipShotPool) {
        this.shipShotPool = shipShotPool;
    }

    public WeakShotPool getWeakShotPool() {
        return weakShotPool;
    }

    public void setWeakShotPool(WeakShotPool weakShotPool) {
        this.weakShotPool = weakShotPool;
    }

    public ImmatureShotPool getImmatureShotPool() {
        return immatureShotPool;
    }

    public void setImmatureShotPool(ImmatureShotPool immatureShotPool) {
        this.immatureShotPool = immatureShotPool;
    }

    public SlickShotPool getSlickShotPool() {
        return slickShotPool;
    }

    public void setSlickShotPool(SlickShotPool slickShotPool) {
        this.slickShotPool = slickShotPool;
    }

    public PowerfulShotPool getPowerfulShotPool() {
        return powerfulShotPool;
    }

    public void setPowerfulShotPool(PowerfulShotPool powerfulShotPool) {
        this.powerfulShotPool = powerfulShotPool;
    }

    public LegendaryShotPool getLegendaryShotPool() {
        return legendaryShotPool;
    }

    public void setLegendaryShotPool(LegendaryShotPool legendaryShotPool) {
        this.legendaryShotPool = legendaryShotPool;
    }
}
