package com.spaceinvaders.model.geometry;

public class Translaction {
    private Position position;
    private Vector v;

    public Translaction(Position position, Vector v) {
        this.position = position;
        this.v = v;
    }

    public Position apply() {
        return new Position(position.getX() + v.getX(), position.getY() + v.getY());
    }
}
