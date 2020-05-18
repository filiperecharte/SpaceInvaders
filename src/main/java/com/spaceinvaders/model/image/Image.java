package com.spaceinvaders.model.image;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;

import java.util.Collections;
import java.util.Comparator;

public class Image extends Box {

    private PixelMatrix pixelMatrix;
    private String color;
    private boolean bold;

    public Image() {
        super(new Position(0, 0), new Size(0, 0));
        this.color = "#000000";
        this.bold = false;
        this.pixelMatrix = new PixelMatrix();
    }

    public PixelMatrix getPixelMatrix() {
        return pixelMatrix;
    }

    public void setPixelMatrix(PixelMatrix pixelMatrix) {
        this.pixelMatrix = pixelMatrix;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBold() {
        return this.bold;
    }

    public void setBold(boolean newBold) {
        this.bold = newBold;
    }

    public void updateSize() {
        Pixel maxPixelX = Collections.max(pixelMatrix.getPixels(), Comparator.comparing(p -> p.getPosition().getX()));
        Pixel maxPixelY = Collections.max(pixelMatrix.getPixels(), Comparator.comparing(p -> p.getPosition().getY()));
        this.size.setWidth(maxPixelX.getPosition().getX() + 1);
        this.size.setHeight(maxPixelY.getPosition().getY() + 1);
    }

    @Override
    public void setPosition(Position position) {

        Vector v = new Vector(this.position, position);

        for (Pixel pixel : pixelMatrix.getPixels()) {
            Translaction translaction = new Translaction(pixel.getPosition(), v);
            pixel.setPosition(translaction.apply());
        }

        super.setPosition(position);
    }
}
