package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class MovableBox extends Box {
    private Vector velocity;

    public MovableBox(Position position, Size size, Vector initialVelocity) {
        super(position, size);
        this.velocity = initialVelocity;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
