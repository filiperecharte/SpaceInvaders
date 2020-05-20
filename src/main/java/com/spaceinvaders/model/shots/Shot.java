package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.box.MovableBox;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class Shot extends MovableBox implements IElementVisited {
    protected int damage;

    public Shot(Position position, Size size, Vector initialVelocity, int damage) {
        super(position, size, initialVelocity);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }

}
