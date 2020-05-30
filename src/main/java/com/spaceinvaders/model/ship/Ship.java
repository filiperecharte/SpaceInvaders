package com.spaceinvaders.model.ship;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shot;

public class Ship extends Box implements IElementVisited, ICollideableVisited, Shooter {
    private HealthyBehavior healthyBehavior;

    public Ship(Position position, Size size, HealthyBehavior healthyBehavior) throws IllegalArgumentException {
        super(position, size);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");

        this.healthyBehavior = healthyBehavior;
    }

    public HealthyBehavior getHealthyBehavior() {
        return healthyBehavior;
    }

    public void setHealthyBehavior(HealthyBehavior healthyBehavior) {
        this.healthyBehavior = healthyBehavior;
    }

    private Position getShootPosition() {
        Translation t = new Translation(this.position, new Vector((this.size.getWidth() - 1) / 2, -1));
        return t.apply();
    }

    @Override
    public void processShot(Shot shot) {
        shot.setPosition(getShootPosition());
        shot.setSize(new Size(1, 1));
        shot.getMovableBehavior().setVelocity(new Vector(0, -1));
        shot.getDamageBehavior().setDamage(1);
        shot.setName("ShipShot");
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
