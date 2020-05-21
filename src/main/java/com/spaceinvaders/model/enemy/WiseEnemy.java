package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.AttackBehavior;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class WiseEnemy extends Enemy {
    public WiseEnemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);
        movableBehavior = new MovableBehavior(new Vector(1, 0));
        healthyBehavior = new HealthyBehavior(5);
        attackBehavior = new AttackBehavior(5);
    }
}
