package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class MovableFrame extends Frame {
    public MovableFrame(Position position, Size size, Image image) {
        super(position, size, image);
        this.setPosition(position);
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
        this.image.setPosition(position);
    }
}
