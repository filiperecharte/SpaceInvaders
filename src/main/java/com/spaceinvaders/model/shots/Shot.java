package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.Frame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class Shot extends Frame {
    protected int damage, speed;

    public Shot(Position position, Size size, Image image, int damage, int speed) {
        super(position, size, image);
        this.damage = damage;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void update() {
        this.image.setPosition(this.position);
    }
}
