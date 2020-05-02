package model.arena;

import model.ShipCreator;
import model.Ship;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor) {

        Ship ship = new ShipCreator().createShip();
        ship.update();

        return new Arena(width, height, backgroundColor, ship);
    }
}
