package com.spaceinvaders.view;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.Ship;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.wall.Wall;

public class GameRenderer implements Renderer{
    private Arena arena;
    private Ship ship;
    private Wall wall;

    public GameRenderer(Arena arena) {
        this.arena = arena;
    }

    public void render(TextGraphics graphics) {
        new ArenaRenderer(arena).render(graphics);
        new ShipRenderer(arena.getShip()).render(graphics);
        for(int i=0;i<arena.getWalls().size();i++)
            new WallRenderer(arena.getWalls().get(i)).render(graphics);
    }

}
