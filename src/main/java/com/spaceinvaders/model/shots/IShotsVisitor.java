package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.shots.shotvariants.*;

public interface IShotsVisitor {
    void visit(ShipShot shipShot);
    void visit(EnemyShot enemyShot);
    void visit(WeakShot weakShot);
    void visit(ImmatureShot immatureShot);
    void visit(SlickShot slickShot);
    void visit(PowerfulShot powerfulShot);
    void visit(LegendaryShot legendaryShot);
}
