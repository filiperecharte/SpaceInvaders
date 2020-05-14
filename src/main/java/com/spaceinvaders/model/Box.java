package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Box extends Element {
    protected Size size;
    public Box(Position position, Size size) {
        super(position);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean contain(Position otherPosition) {
        boolean checkHorizontal = (otherPosition.getX() >= position.getX()) && (otherPosition.getX() <= position.getX() + size.getWidth());
        boolean checkVertical = (otherPosition.getY() >= position.getY()) && (otherPosition.getY() <= position.getY() + size.getHeight());

        return checkHorizontal && checkVertical;
    }
}
