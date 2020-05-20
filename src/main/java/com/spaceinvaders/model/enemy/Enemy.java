package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shooter;

public class Enemy extends Box implements IElementVisited, ICollideableVisited, Shooter {
    private MovableBehavior movableBehavior;
    private HealthyBehavior healthyBehavior;

    public Enemy(Position position, Size size, MovableBehavior movableBehavior, HealthyBehavior healthyBehavior) throws IllegalArgumentException {
        super(position, size);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");

        this.movableBehavior = movableBehavior;
        this.healthyBehavior = healthyBehavior;
    }

    public MovableBehavior getMovableBehavior() {
        return movableBehavior;
    }

    public void setMovableBehavior(MovableBehavior movableBehavior) {
        this.movableBehavior = movableBehavior;
    }

    public HealthyBehavior getHealthyBehavior() {
        return healthyBehavior;
    }

    public void setHealthyBehavior(HealthyBehavior healthyBehavior) {
        this.healthyBehavior = healthyBehavior;
    }

    @Override
    public Position getShootPosition() {
        Translation t = new Translation(this.position, new Vector((this.size.getWidth() - 1) / 2, 0));
        return t.apply();
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptShot(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }
}