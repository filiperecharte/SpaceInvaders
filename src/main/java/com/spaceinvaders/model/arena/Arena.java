package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.Element;
import com.spaceinvaders.model.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.Ship;
import com.spaceinvaders.model.wall.Wall;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    private Ship ship;
    private List<Wall> walls;
    private String backgroundColor;

    public Arena(int width, int height, String backgroundColor){
        this.height=height;
        this.width=width;
        this.backgroundColor = backgroundColor;
        this.walls = new ArrayList<>();
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

    public void addElement(Element element) {
        if (element instanceof Ship) ship = (Ship) element;
        if (element instanceof Wall) walls.add((Wall) element);
    }


    public Ship getShip(){
        return this.ship;
    }

    public Position getShipPosition() {
        return ship.getPosition();
    }

    public List<Wall> getWalls(){return this.walls;}

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
