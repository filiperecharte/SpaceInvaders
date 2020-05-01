package model.arena;

import model.ShipCreator;
import model.geometry.Position;
import model.Ship;
import model.geometry.Size;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor) {

        //Ship ship = new Ship(new Position(30, 22), new Size(5, 1));

        Ship ship = new ShipCreator().createShip();
        ship.update();

        return new Arena(width, height, backgroundColor, ship);
    }
}
