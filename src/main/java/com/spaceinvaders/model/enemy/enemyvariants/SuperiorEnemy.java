package com.spaceinvaders.model.enemy.enemyvariants;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.AttackBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.shots.enemyshotvariants.LegendaryShot;
import com.spaceinvaders.model.shots.enemyshotvariants.WeakShot;

public class SuperiorEnemy extends Enemy implements Shooter {
    public SuperiorEnemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);
        movableBehavior = new MovableBehavior(new Vector(2, 0));
        healthyBehavior = new HealthyBehavior(10);
        attackBehavior = new AttackBehavior(5);
    }

    @Override
    public Shot createShot() { return new LegendaryShot(); }

    @Override
    public Object getShotType() { return LegendaryShot.class; }
}
