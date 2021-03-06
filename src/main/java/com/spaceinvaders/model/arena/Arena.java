package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.element.ElementsVisitor;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.collisions.CollideableVisitor;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Wall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Arena extends Box {
    private Ship ship;
    private List<Wall> walls;
    private List<Enemy> enemies;
    private List<Shot> shots;
    private long score;


    public Arena(Position position, Size size){
        super(position,size);
        this.enemies = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.score = 0;
    }

    public boolean canMove(Position position) {
        if (position.getX() < 0 || position.getX() >= size.getWidth()) return false;
        if (position.getY() < 0 || position.getY() >= size.getHeight()) return false;

        return true;
    }

    public void moveShipTo(Position position) {
        if (canMove(position))
            ship.setPosition(position);
    }

    public void addElement(IElementVisited element) {
        element.accept(new ElementsVisitor(this));
    }

    public void collide(ICollideableVisited collideable, Shot shot){
        collideable.accept(new CollideableVisitor(this, shot));
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

    public Enemy getLeftMostEnemy(){
        return Collections.min(enemies, Comparator.comparing(p -> p.getPosition().getX()));
    }

    public Enemy getRightMostEnemy(){
        return Collections.max(enemies, Comparator.comparing(p -> p.getPosition().getX()));
    }

    public void increaseScore(){
        score+=10;
    }

    public long getScore(){
        return score;
    }
}
