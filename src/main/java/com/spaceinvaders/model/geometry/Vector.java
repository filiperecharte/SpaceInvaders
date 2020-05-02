package com.spaceinvaders.model.geometry;

public class Vector {
    int x, y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Position origin, Position dest) {
        Position subPosition = dest.sub(origin);
        this.x = subPosition.getX();
        this.y = subPosition.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
