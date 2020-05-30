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

public class StrongEnemy extends Enemy implements Shooter {
    public StrongEnemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);
        movableBehavior = new MovableBehavior(new Vector(1, 0));
        healthyBehavior = new HealthyBehavior(5);
        attackBehavior = new AttackBehavior(15);
    }

    @Override
    public void processShot(Shot shot) {
        shot.setPosition(getShootPosition());
        shot.setSize(new Size(1, 1));
        shot.getMovableBehavior().setVelocity(new Vector(0, 1));
        shot.getDamageBehavior().setDamage(4);
        shot.setName("PowerfulShot");
    }
}
