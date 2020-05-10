package com.spaceinvaders.model.geometry;

public class Size {
    protected int width;
    protected int height;

    public Size(int width, int height) throws IllegalArgumentException {

        if (width < 0)
            throw new IllegalArgumentException("width must be >= 0");

        if (height < 0)
            throw new IllegalArgumentException("height must be >= 0");

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean equals(Size otherSize) {
        return (width == otherSize.getWidth()) && (height == otherSize.getHeight());
    }

    public boolean fitIn(Size otherSize) {
        return (width <= otherSize.getWidth()) && (height <= otherSize.getHeight());
    }
}
