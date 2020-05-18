package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Fragment extends Box implements ICollideableVisited {
    private char c;

    public Fragment(Position position, Size size, char c) {
        super(position, size);
        this.c=c;

    }

    public char getChar(){
        return c;
    }

    @Override
    public void acceptShot(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }
}
