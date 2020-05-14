package com.spaceinvaders.model.arena;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.ship.ShipCreator;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.enemy.DefaultEnemyCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.wall.DefaultWallCreator;

public class ArenaCreator {

    public Arena createArena(Position position,Size size, String backgroundColor) {
        Arena arena = new Arena(position,size, backgroundColor);
        Ship ship = new ShipCreator().createShip();
        arena.addElement(ship);

        int Wposx=5; //posicao da primeira parede
        for(int i=0;i<5;i++) {
            arena.addElement((new DefaultWallCreator()).build(new Position(Wposx, 18), new Size(5, 5)));
            Wposx+=15;
        }

        int Eposx=5; //posicao do primeiro inimigo
        int Eposy=10;
        for(int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                arena.addElement((new DefaultEnemyCreator()).build(new Position(Eposx, Eposy), new Size(3, 1)));
                Eposx += 3;
            }
            Eposx=5;
            Eposy-=1;
        }

        return arena;
    }
}
