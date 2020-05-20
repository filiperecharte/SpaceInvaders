package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Fragment extends Box implements ICollideableVisited {

    public Fragment(Position position, Size size) {
        super(position, size);
    }

    @Override
    public void acceptShot(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
