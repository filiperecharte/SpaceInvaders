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

public class SuperiorEnemy extends Enemy implements Shooter {
    public SuperiorEnemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size, "SuperiorEnemyImg");
        movableBehavior = new MovableBehavior(new Vector(2, 0));
        healthyBehavior = new HealthyBehavior(10);
        attackBehavior = new AttackBehavior(5);
    }

    @Override
    public void processShot(Shot shot) {
        shot.setPosition(getShootPosition());
        shot.setSize(new Size(1, 1));
        shot.getMovableBehavior().setVelocity(new Vector(0, 1));
        shot.getDamageBehavior().setDamage(5);
        shot.setName("LegendaryShot");
        shot.setImageName("LegendaryShotImg");
    }
}
