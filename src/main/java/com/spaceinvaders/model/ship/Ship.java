package com.spaceinvaders.model.ship;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.HealthyBox;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shot;

public class Ship extends Box implements IElementVisited, ICollideableVisited, Shooter {

    private HealthyBehavior healthyBehavior;
    private int lifes = 3;

    public Ship(Position position, Size size, HealthyBehavior healthyBehavior) throws IllegalArgumentException {
        super(position, size);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");

        this.healthyBehavior = healthyBehavior;
    }

    public int getLifes(){
        return lifes;
    }

    public void setLifes(int lifes1){
        lifes=lifes1;
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
    public Shot createShot() {
        return new ShipShot();
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptShot(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }

    @Override
    public Object getShotType() {
        return ShipShot.class;
    }
}
