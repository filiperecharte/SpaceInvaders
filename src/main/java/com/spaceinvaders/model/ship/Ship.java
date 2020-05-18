package com.spaceinvaders.model.ship;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.shots.Shot;

public class Ship extends MovableFrame implements IElementVisited, ICollideableVisited, Shooter {
    private int life=5;

    public Ship(Position position, Size size, Image image) throws IllegalArgumentException {
        super(position, size, image);

        if (!this.isPerfectlyOverlapped())
            throw new IllegalArgumentException("Image must perfectly overlap Box");

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
    }

    public void decreaseLife(){
        life--;
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
