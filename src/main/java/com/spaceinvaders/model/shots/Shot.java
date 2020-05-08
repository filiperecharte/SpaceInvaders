package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.Frame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class Shot extends Frame {
    protected int damage;

    public Shot(Position position, Size size, Image image, int damage) {
        super(position, size, image);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void update() {
        this.image.setPosition(this.position);
    }
}
