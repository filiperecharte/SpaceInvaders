package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;

public class Shot extends MovableFrame implements IElementVisited {
    protected int damage;
    protected Vector velocity;

    public Shot(Position position, Size size, Image image, int damage, Vector velocity) {
        super(position, size, image);
        this.damage = damage;
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void update() {
        this.image.setPosition(this.position);
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
