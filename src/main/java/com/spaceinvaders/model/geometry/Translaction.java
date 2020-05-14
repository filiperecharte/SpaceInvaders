package com.spaceinvaders.model.geometry;

public class Translaction {
    private Position position;
    private Vector v;

    public Translaction() {
        position = new Position(0, 0);
        v = new Vector(0, 0);
    }

    public Translaction(Position position, Vector v) {
        this.position = position;
        this.v = v;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setVector(Vector v) {
        this.v = v;
    }

    public Position apply() {
        return new Position(position.getX() + v.getX(), position.getY() + v.getY());
    }
}
