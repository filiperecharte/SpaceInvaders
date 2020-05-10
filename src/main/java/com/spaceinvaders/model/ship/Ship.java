package com.spaceinvaders.model.ship;

import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.Shooter;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class Ship extends MovableFrame implements Shooter {

    public Ship(Position position, Size size, Image image){
        super(position, size, image);
        this.image = image;
    }

    @Override
    public Position getShootPosition() {
        return null;
    }
}
