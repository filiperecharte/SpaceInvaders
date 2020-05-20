package com.spaceinvaders.model.behaviors;

import com.spaceinvaders.model.geometry.Vector;

public class MovableBehavior {
    private Vector velocity;

    public MovableBehavior(Vector velocity) {
        this.velocity = velocity;
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
