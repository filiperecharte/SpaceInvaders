package Controller;

import Model.Position;

public class NeighboursPosition {
    private Position position;
    private int distance;

    public NeighboursPosition(Position position) {
        this.position = position;
        this.distance = 1;
    }

    public NeighboursPosition(Position position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    public Position up() {
        return new Position(position.getX(), position.getY() + distance);
    }

    public Position down() {
        return new Position(position.getX(), position.getY() - distance);
    }

    public Position left() {
        return new Position(position.getX() - distance, position.getY());
    }

    public Position right() {
        return new Position(position.getX() + distance, position.getY());
    }
}
