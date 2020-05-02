package com.spaceinvaders.view;

import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.Ship;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GameRenderer implements Renderer{
    private Arena arena;
    private Ship ship;

    public GameRenderer(Arena arena,Ship ship) {
        this.arena = arena;
        this.ship=ship;
    }

    public void render(TextGraphics graphics) {
        new ArenaRenderer(arena).render(graphics);
        new ShipRenderer(ship).render(graphics);
    }

}
