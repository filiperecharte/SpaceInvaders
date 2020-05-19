package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.MovableBox;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shooter;

public class Enemy extends MovableBox implements IElementVisited, ICollideableVisited, Shooter {

    public Enemy(Position position, Size size, Vector initialVelocity) throws IllegalArgumentException {
        super(position, size, initialVelocity);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
    }

    public void update() {
        Translaction t = new Translaction(this.position,new Vector(direction,0));
        this.setPosition(t.apply());
    }

    @Override
    public Position getShootPosition() {
        Translaction t = new Translaction(this.position, new Vector((this.size.getWidth() - 1) / 2, 0));
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