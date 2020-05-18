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

        Ship ship = null;

        try {
            ship = new Ship(new Position(30, 22), new Size(5, 1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return ship;
    }
}
