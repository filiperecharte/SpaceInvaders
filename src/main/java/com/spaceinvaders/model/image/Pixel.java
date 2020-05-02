package com.spaceinvaders.model.image;

import com.spaceinvaders.model.Element;
import com.spaceinvaders.model.geometry.Position;

public class Pixel extends Element {
    char c;
    public Pixel(Position position, char c) {
        super(position);
        this.c = c;
    }

    public char getCharacter() {
        return this.c;
    }

    public void setCharacter(char newC) {
        this.c = newC;
    }
}
