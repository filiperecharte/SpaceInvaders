package com.spaceinvaders.model.geometry;

import java.util.Objects;

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

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return width == size.width &&
                height == size.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
