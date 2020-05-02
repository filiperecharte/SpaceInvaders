package model.arena;

import model.geometry.Position;
import model.Ship;

public class Arena {
    private int width;
    private int height;
    private Ship ship;
    private String backgroundColor;

    public Arena(int width, int height, String backgroundColor, Ship ship){
        this.height=height;
        this.width=width;
        this.backgroundColor = backgroundColor;
        this.ship= ship;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean canMove(Position position) {
        if (position.getX() < 0 || position.getX() >= width) return false;
        if (position.getY() < 0 || position.getY() >= height) return false;

        return true;
    }

    public void moveShipTo(Position position) {
        ship.setPosition(position);
        ship.update();

    }

    public Ship getShip(){
        return this.ship;
    }

    public Position getShipPosition() {
        return ship.getPosition();
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
