package com.spaceinvaders.model.element;

import com.spaceinvaders.model.geometry.Position;

public class Element {
    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
