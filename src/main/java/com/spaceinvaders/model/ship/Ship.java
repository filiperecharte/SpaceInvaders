package com.spaceinvaders.model.ship;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.shots.Shooter;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;

public class Ship extends Box implements IElementVisited, Shooter {

public Ship(Position position, Size size) throws IllegalArgumentException

    {
        super(position, size);

        if (size.getWidth() % 2 == 0)
            throw new IllegalArgumentException("Ship size must be odd");
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
}
