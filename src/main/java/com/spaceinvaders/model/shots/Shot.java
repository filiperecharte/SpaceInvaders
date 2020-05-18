package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class Shot extends Box implements IElementVisited {
    protected int damage;
    protected Vector velocity;

    public Shot(Position position, Size size, int damage, Vector velocity) {
        super(position, size);
        this.damage = damage;
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage;
    }

    public Vector getVelocity() {
        return velocity;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
