package com.spaceinvaders.model.enemy;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.Shooter;

public class Enemy extends Box implements IElementVisited, ICollideableVisited, Shooter {
    private int direction;

    public Enemy(Position position, Size size) throws IllegalArgumentException {
        super(position, size);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
        this.direction=1;
    }

    public void update() {
        Translaction t = new Translaction(this.position,new Vector(direction,0));
        this.setPosition(t.apply());
    }

    public  void setDirection(int dir){
        this.direction=dir;
    }

    public  int getDirection(){
        return direction;
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