package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.*;
import com.spaceinvaders.model.collisions.CollideableVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Wall;

import java.util.ArrayList;
import java.util.List;

public class Arena extends Box{
    private Ship ship;
    private List<Wall> walls;
    private List<Enemy> enemies;
    private List<Shot> shots;
    private String backgroundColor;


    public Arena(Position position, Size size, String backgroundColor){
        super(position,size);
        this.backgroundColor=backgroundColor;
        this.enemies = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.shots = new ArrayList<>();
    }

    public boolean canMove(Position position) {
        if (position.getX() < 0 || position.getX() >= size.getWidth()) return false;
        if (position.getY() < 0 || position.getY() >= size.getHeight()) return false;

        return true;
    }

    public void moveShipTo(Position position) {
        ship.setPosition(position);
    }

    /*public void addElement(Element element) {
        if (element instanceof Ship) ship = (Ship) element;
        if (element instanceof Wall) walls.add((Wall) element);
        if (element instanceof Enemy) enemies.add((Enemy) element);
        if (element instanceof Shot) shots.add((Shot) element);
    }*/

    public void addElement(IElementVisited element) {
        element.accept(new ElementsVisitor(this));
    }

    public void colide(ICollideableVisited collideable,Shot shot){
        collideable.acceptShot(new CollideableVisitor(this, shot));
    }

    public Ship getShip(){
        return this.ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Position getShipPosition() {
        return ship.getPosition();
    }

    public List<Wall> getWalls(){return this.walls;}

    public List<Enemy> getEnemies(){return this.enemies;}

    public List<Shot> getShots() {
        return this.shots;
    }

    public void changeEnemiesDir(){
        for (int i=0;i<enemies.size();i++){
            enemies.get(i).setDirection(-enemies.get(i).getDirection());
        }
    }

    public void updateEnemies(){
        for (int i=0;i<enemies.size();i++){
            enemies.get(i).update();
        }
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
