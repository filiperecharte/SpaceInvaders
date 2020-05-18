package com.spaceinvaders.view;

import com.googlecode.lanterna.TextColor;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.view.lanternaview.imagesfactories.ArenaImageFactory;
import com.spaceinvaders.view.lanternaview.imagesfactories.ShipImageFactory;
import com.spaceinvaders.view.lanternaview.imagesrederers.BoxImageRenderer;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class GameRenderer implements Renderer {
    private Arena arena;
    int counter;

    public GameRenderer(Arena arena) {
        this.arena = arena;
        counter=0;
    }

    public void render(TextGraphics graphics) {

        //graphics.fill(' ');
        TextColor backgroundColor = new TextColor.RGB(128, 128, 128);

        //new ArenaRenderer(arena).render(graphics);
        new BoxImageRenderer(arena, new ArenaImageFactory().createTextImage(backgroundColor)).render(graphics);
        new BoxImageRenderer(arena.getShip(), new ShipImageFactory().createTextImage(backgroundColor)).render(graphics);

        for(int i=0;i<arena.getWalls().size();i++)
            new WallRenderer(arena.getWalls().get(i)).render(graphics);

        for(int i=0;i<arena.getEnemies().size();i++){
            new EnemyRenderer(arena.getEnemies().get(i)).render(graphics);
        }

        for (Shot shot : arena.getShots()) {
            new ShotRenderer(shot).render(graphics);
        }

    }

}
