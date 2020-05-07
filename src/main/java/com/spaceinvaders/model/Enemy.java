package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Enemy extends Box {
    private Position position;

    public Enemy(Position position, Size size) {
        super(position, size);
    }

}