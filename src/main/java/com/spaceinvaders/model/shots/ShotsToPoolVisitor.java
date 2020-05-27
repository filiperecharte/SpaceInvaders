package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.enemyshotvariants.*;

public class ShotsToPoolVisitor implements IShotsVisitor {
    private ShotPoolGroup shotPoolGroup;

    public ShotsToPoolVisitor(ShotPoolGroup shotPoolGroup) {
        this.shotPoolGroup = shotPoolGroup;
    }

    @Override
    public void visit(ShipShot shipShot) {
        shotPoolGroup.getShipShotPool().put(shipShot);
    }

    @Override
    public void visit(WeakShot weakShot) {
        shotPoolGroup.getWeakShotPool().put(weakShot);
    }

    @Override
    public void visit(ImmatureShot immatureShot) {
        shotPoolGroup.getImmatureShotPool().put(immatureShot);
    }

    @Override
    public void visit(SlickShot slickShot) {
        shotPoolGroup.getSlickShotPool().put(slickShot);
    }

    @Override
    public void visit(PowerfulShot powerfulShot) {
        shotPoolGroup.getPowerfulShotPool().put(powerfulShot);
    }

    @Override
    public void visit(LegendaryShot legendaryShot) {
        shotPoolGroup.getLegendaryShotPool().put(legendaryShot);
    }
}
