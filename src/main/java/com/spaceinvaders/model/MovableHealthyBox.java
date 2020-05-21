package com.spaceinvaders.model;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class MovableHealthyBox extends HealthyBox {
    private Vector velocity;

    public MovableHealthyBox(Position position, Size size, int health, Vector initialVelocity) throws IllegalArgumentException {
        super(position, size, health);
        this.velocity = initialVelocity;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void invertVelocity() {
        velocity.setX(-velocity.getX());
        velocity.setY(-velocity.getY());
    }
}
