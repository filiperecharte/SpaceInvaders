package com.spaceinvaders.view.lanternaview.staterenderers;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import com.spaceinvaders.view.lanternaview.ShotsRendererVisitor;
import com.spaceinvaders.view.lanternaview.imagesfactories.*;
import com.spaceinvaders.view.lanternaview.imagesrederers.BoxImageRenderer;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class PlayRenderer implements Renderer {
    private Arena arena;
    private ArenaImageFactory arenaImageFactory;
    private ShipImageFactory shipImageFactory;
    private EnemyImageFactory enemyImageFactory;
    private DefaultFragmentImageFactory defaultFragmentImageFactory;
    private TextColor backgroundColor;

    public PlayRenderer(Arena arena) {
        this.arena = arena;
        this.arenaImageFactory = new ArenaImageFactory();
        this.shipImageFactory = new ShipImageFactory();
        this.enemyImageFactory = new EnemyImageFactory();
        this.defaultFragmentImageFactory = new DefaultFragmentImageFactory();
        this.backgroundColor = new TextColor.RGB(128, 128, 128);
    }

    public void render(TextGraphics graphics) {
        new BoxImageRenderer(arena, arenaImageFactory.createTextImage(arena,backgroundColor)).render(graphics);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(3,1,"HEALTH", SGR.BOLD);
        graphics.putString(10,1,Integer.toString(arena.getShip().getHealthyBehavior().getCurrentHealth()), SGR.BOLD);
        graphics.putString(3,23,"ESC TO MENU", SGR.BOLD);

        new BoxImageRenderer(arena.getShip(), shipImageFactory.createTextImage(arena.getShip(),backgroundColor)).render(graphics);
        for (Enemy enemy : arena.getEnemies()) {
            new BoxImageRenderer(enemy, enemyImageFactory.createTextImage(enemy,backgroundColor)).render(graphics);
        }
        for (Wall wall : arena.getWalls()) {
            for (Fragment fragment : wall.getFragments()) {
                new BoxImageRenderer(fragment, defaultFragmentImageFactory.createTextImage(fragment, backgroundColor)).render(graphics);
            }
        }
        IShotVisited shotVisited;
        for (Shot shot : arena.getShots()) {
            shotVisited = (IShotVisited)shot;
            shotVisited.accept(new ShotsRendererVisitor(backgroundColor, graphics));
        }


    }

}
