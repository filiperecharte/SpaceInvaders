package com.spaceinvaders.view;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.Ship;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Translaction;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.wall.Wall;

public class GameRenderer implements Renderer{
    private Arena arena;
    int counter;

    public GameRenderer(Arena arena) {
        this.arena = arena;
        counter=0;
    }

    public void render(TextGraphics graphics) {
        new ArenaRenderer(arena).render(graphics);
        new ShipRenderer(arena.getShip()).render(graphics);

        for(int i=0;i<arena.getWalls().size();i++)
            new WallRenderer(arena.getWalls().get(i)).render(graphics);

        for(int i=0;i<arena.getEnemies().size();i++){
            new EnemyRenderer(arena.getEnemies().get(i)).render(graphics);
        }

    }

}
