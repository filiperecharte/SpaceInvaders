package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.AttackBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class SuperiorEnemy extends Enemy {
    public SuperiorEnemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);
        movableBehavior = new MovableBehavior(new Vector(2, 0));
        healthyBehavior = new HealthyBehavior(10);
        attackBehavior = new AttackBehavior(5);
    }
}
