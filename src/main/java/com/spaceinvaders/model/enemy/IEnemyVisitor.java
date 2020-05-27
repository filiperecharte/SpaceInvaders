package com.spaceinvaders.model.enemy;

import com.spaceinvaders.model.enemy.enemyvariants.*;

public interface IEnemyVisitor {
    void visit(OldEnemy oldEnemy);
    void visit(YoungEnemy youngEnemy);
    void visit(WiseEnemy wiseEnemy);
    void visit(StrongEnemy strongEnemy);
    void visit(SuperiorEnemy superiorEnemy);
}
