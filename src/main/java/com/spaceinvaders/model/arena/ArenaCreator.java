package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.ShipCreator;
import com.spaceinvaders.model.Ship;
import com.spaceinvaders.model.wall.DefaultWallCreator;
import com.spaceinvaders.model.wall.Wall;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor ) {
        Arena arena = new Arena(width, height, backgroundColor);
        Ship ship = new ShipCreator().createShip();
        arena.addElement((new DefaultWallCreator()).build());
        arena.addElement(ship);

        ship.update();

        return new Arena(width, height, backgroundColor);
    }
}
