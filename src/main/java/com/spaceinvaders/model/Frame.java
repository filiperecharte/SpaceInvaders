package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class Frame extends Box {
    protected Image image;

    public Frame(Position position, Size size, Image image) throws IllegalArgumentException {
        super(position, size);

        if (!image.getSize().fitIn(size))
            throw new IllegalArgumentException("Image must fit in Box");

        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isPerfectlyOverlapped() {
        return image.getSize().equals(this.size);
    }
}
