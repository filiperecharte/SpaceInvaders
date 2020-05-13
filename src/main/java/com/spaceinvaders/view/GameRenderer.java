package com.spaceinvaders.view;

import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.shots.Shot;

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

        for (Shot shot : arena.getShots()) {
            System.out.println("X: " + shot.getPosition().getX());
            System.out.println("Y: " + shot.getPosition().getY());
            new ShotRenderer(shot).render(graphics);
        }

    }

}
