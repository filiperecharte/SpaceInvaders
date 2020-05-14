package com.spaceinvaders.model.enemy;

import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.shots.Shooter;

public class Enemy extends MovableFrame implements IElementVisited, Shooter {
    private int direction;

    public Enemy(Position position, Size size, Image image) {
        super(position, size, image);
        this.direction=1;
    }

    public void update() {
        Translaction t = new Translaction(this.position,new Vector(direction,0));
        this.setPosition(t.apply());
    }

    public  void setDirection(int dir){
        this.direction=dir;
    }

    public  int getDirection(){
        return direction;
    }

    @Override
    public Position getShootPosition() {
        Translaction t = new Translaction(this.position, new Vector((this.size.getWidth() - 1) / 2, 0));
        return t.apply();
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}