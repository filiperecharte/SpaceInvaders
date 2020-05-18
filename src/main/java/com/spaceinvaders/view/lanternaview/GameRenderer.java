package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import com.spaceinvaders.view.lanternaview.ShotsRendererVisitor;
import com.spaceinvaders.view.lanternaview.imagesfactories.ArenaImageFactory;
import com.spaceinvaders.view.lanternaview.imagesfactories.DefaultEnemyImageFactory;
import com.spaceinvaders.view.lanternaview.imagesfactories.DefaultFragmentImageFactory;
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

        TextColor backgroundColor = new TextColor.RGB(128, 128, 128);

        new BoxImageRenderer(arena, new ArenaImageFactory().createTextImage(backgroundColor)).render(graphics);
        new BoxImageRenderer(arena.getShip(), new ShipImageFactory().createTextImage(backgroundColor)).render(graphics);
        for (Enemy enemy : arena.getEnemies()) {
            new BoxImageRenderer(enemy, new DefaultEnemyImageFactory().createTextImage(backgroundColor)).render(graphics);
        }
        for (Wall wall : arena.getWalls()) {
            for (Fragment fragment : wall.getFragments()) {
                new BoxImageRenderer(fragment, new DefaultFragmentImageFactory().createTextImage(backgroundColor)).render(graphics);
            }
        }
        IShotVisited shotVisited;
        for (Shot shot : arena.getShots()) {
            shotVisited = (IShotVisited)shot;
            shotVisited.accept(new ShotsRendererVisitor(backgroundColor, graphics));
        }
    }

}
