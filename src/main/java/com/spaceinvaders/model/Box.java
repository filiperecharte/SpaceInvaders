package com.spaceinvaders.model;

import com.spaceinvaders.model.element.Element;
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
        boolean checkHorizontal = (otherPosition.getX() >= position.getX()) && (otherPosition.getX() <= position.getX() + size.getWidth()-1);
        boolean checkVertical = (otherPosition.getY() >= position.getY()) && (otherPosition.getY() <= position.getY() + size.getHeight()-1);

        return checkHorizontal && checkVertical;
    }

    public boolean contain(Box otherBox) {
        boolean checkWidth = (otherBox.getPosition().getX() + otherBox.getSize().getWidth()) < (this.getPosition().getX() + this.getSize().getWidth());
        boolean checkHeight = (otherBox.getPosition().getY() + otherBox.getSize().getHeight()) < (this.getPosition().getY() + this.getSize().getHeight());
        boolean checkX = otherBox.getPosition().getX() > this.getPosition().getX();
        boolean checkY = otherBox.getPosition().getY() > this.getPosition().getY();
        return checkWidth && checkHeight && checkX && checkY;
    }
}
