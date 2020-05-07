package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Fragment extends Box{
    private char c;
    public Fragment(Position position, Size size, char c) {
        super(position, size);
        this.c=c;
    }

    public char getChar(){
        return c;
    }

}
