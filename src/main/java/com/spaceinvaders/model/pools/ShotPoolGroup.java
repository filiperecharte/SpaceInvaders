package com.spaceinvaders.model.pools;

import com.spaceinvaders.model.pools.shotpools.EnemyShotPool;
import com.spaceinvaders.model.pools.shotpools.ShipShotPool;
import com.spaceinvaders.model.pools.shotpools.enemyshotpools.*;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.ShotsPoolVisitor;

public class ShotPoolGroup {
    private ShipShotPool shipShotPool;
    private EnemyShotPool enemyShotPool;
    private WeakShotPool weakShotPool;
    private ImmatureShotPool immatureShotPool;
    private SlickShotPool slickShotPool;
    private PowerfulShotPool powerfulShotPool;
    private LegendaryShotPool legendaryShotPool;

    public ShotPoolGroup() {
        shipShotPool = new ShipShotPool();
        enemyShotPool = new EnemyShotPool();
        weakShotPool = new WeakShotPool();
        immatureShotPool = new ImmatureShotPool();
        slickShotPool = new SlickShotPool();
        powerfulShotPool = new PowerfulShotPool();
        legendaryShotPool = new LegendaryShotPool();
    }

    public void put(IShotVisited shot) {
        shot.accept(new ShotsPoolVisitor(this));
    }

    public ShipShotPool getShipShotPool() {
        return shipShotPool;
    }

    public void setShipShotPool(ShipShotPool shipShotPool) {
        this.shipShotPool = shipShotPool;
    }

    public EnemyShotPool getEnemyShotPool() {
        return enemyShotPool;
    }

    public void setEnemyShotPool(EnemyShotPool enemyShotPool) {
        this.enemyShotPool = enemyShotPool;
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
