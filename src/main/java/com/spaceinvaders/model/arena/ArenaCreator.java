package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.ShipCreator;
import com.spaceinvaders.model.Ship;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor) {

        Ship ship = new ShipCreator().createShip();
        ship.update();

        return new Arena(width, height, backgroundColor, ship);
    }
}
