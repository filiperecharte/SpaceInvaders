package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.behaviors.AttackBehavior;
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
import com.spaceinvaders.model.shots.Shot;

public class Enemy extends Box implements IElementVisited, ICollideableVisited, Shooter {
    protected MovableBehavior movableBehavior;
    protected HealthyBehavior healthyBehavior;
    protected AttackBehavior attackBehavior;
    protected String imageName;

    public Enemy(Position position, Size size, String imageName) throws IllegalArgumentException {
        super(position, size);
        this.imageName = imageName;
        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
    }

    public Enemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);
        this.imageName = "";
        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
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

    public AttackBehavior getAttackBehavior() {
        return attackBehavior;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public String getImageName() {
        return imageName;
    }

    public Position getShootPosition() {
        Translation t = new Translation(this.position, new Vector((this.size.getWidth() - 1) / 2, 1));
        return t.apply();
    }

    @Override
    public void recycleShot(Shot shot) {}

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }
}