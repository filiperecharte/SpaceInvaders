package com.spaceinvaders.model.enemy;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

public class Enemy extends Box {
    private Image image;
    private int direction;

    public Enemy(Position position, Size size) {
        super(position, size);
        this.image=image;
        this.direction=1;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image newImage) {
        this.image = newImage;
    }

    public void update() {
        Translaction t = new Translaction(this.position,new Vector(direction,0));
        this.setPosition(t.apply());
        this.image.setPosition(t.apply());
    }

    public  void setDirection(int dir){
        this.direction=dir;
    }

    public  int getDirection(){
        return direction;
    }

}