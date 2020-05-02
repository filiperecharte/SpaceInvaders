package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Enemy extends Box {
    private Position position;
    private boolean isAlive;

    public Enemy(Position position, Size size) {
        super(position, size);
        isAlive=true;
    }

}