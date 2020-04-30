package controller;

import model.geometry.Position;

public class NeighboursPosition {
    private Position position;
    private int range;

    public NeighboursPosition(Position position) {
        this.position = position;
        this.range = 1;
    }

    public NeighboursPosition(Position position, int range) {
        this.position = position;
        this.range = range;
    }

    public Position up() {
        return new Position(position.getX(), position.getY() - range);
    }

    public Position down() {
        return new Position(position.getX(), position.getY() + range);
    }

    public Position left() {
        return new Position(position.getX() - range, position.getY());
    }

    public Position right() {
        return new Position(position.getX() + range, position.getY());
    }
}
