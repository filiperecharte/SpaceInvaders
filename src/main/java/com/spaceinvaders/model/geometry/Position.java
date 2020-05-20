package com.spaceinvaders.model.geometry;

import java.util.Objects;

public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position add(Position otherPosition) {
        return new Position(x + otherPosition.getX(), y + otherPosition.getY());
    }

    public Position sub(Position otherPosition) {
        return new Position(x - otherPosition.getX(), y - otherPosition.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /*public boolean equals(Position otherPosition) {
        return (x == otherPosition.getX()) && (y == otherPosition.getY());
    }*/

}
