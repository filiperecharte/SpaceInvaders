package com.spaceinvaders.model.ship;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;
import com.spaceinvaders.model.ship.Ship;

public class ShipCreator {

    public Ship createShip() {
        Image shipImage = new Image();

        PixelMatrix imagePixelMatrix = shipImage.getPixelMatrix();

        try {
            imagePixelMatrix.addPixel(new Pixel(new Position(0, 0), '/'));
            imagePixelMatrix.addPixel(new Pixel(new Position(1, 0), '-'));
            imagePixelMatrix.addPixel(new Pixel(new Position(2, 0), '^'));
            imagePixelMatrix.addPixel(new Pixel(new Position(3, 0), '-'));
            imagePixelMatrix.addPixel(new Pixel(new Position(4, 0), '\\'));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        shipImage.setColor("#FFFF33");
        shipImage.setBold(true);

        shipImage.updateSize();

        Ship ship = null;

        try {
            ship = new Ship(new Position(30, 22), new Size(5, 1), shipImage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return ship;
    }
}
