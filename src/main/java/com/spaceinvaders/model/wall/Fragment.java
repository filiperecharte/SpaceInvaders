package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

public class Fragment extends Box implements ICollideableVisited {
    private char c;
    private Image image;

    public Fragment(Position position, Size size, Image image, char c) {
        super(position, size);
        this.c=c;
        this.image= image;

    }

    public char getChar(){
        return c;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public void acceptShot(ICollideableVisitor collideableVisitor) {
        collideableVisitor.visit(this);
    }
}
