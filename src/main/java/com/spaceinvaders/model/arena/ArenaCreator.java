package com.spaceinvaders.model.arena;

import com.spaceinvaders.model.ShipCreator;
import com.spaceinvaders.model.Ship;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.wall.DefaultWallCreator;
import com.spaceinvaders.model.wall.Wall;

public class ArenaCreator {

    public Arena createArena(Position position,Size size, String backgroundColor ) {
        Arena arena = new Arena(position,size, backgroundColor);
        Ship ship = new ShipCreator().createShip();

        int posx=5; //posicao da primeira parede
        for(int i=0;i<5;i++) {
            arena.addElement((new DefaultWallCreator()).build(new Position(posx, 18), new Size(5, 5)));
            posx+=15;
        }
        arena.addElement(ship);
        ship.update();

        return arena;
    }
}
