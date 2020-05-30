package com.spaceinvaders.view.lanternaview.staterenderers;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import com.spaceinvaders.view.lanternaview.imagesfactories.*;
import com.spaceinvaders.view.lanternaview.imagesrederers.BoxImageRenderer;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class PlayRenderer implements Renderer {
    private Arena arena;
    private ArenaImageFactory arenaImageFactory;
    private ShipImageFactory shipImageFactory;
    private EnemyImageFactory enemyImageFactory;
    private ShotImageFactory shotImageFactory;
    private DefaultFragmentImageFactory defaultFragmentImageFactory;
    private TextColor backgroundColor;
    private BoxImageRenderer boxImageRenderer;

    public PlayRenderer(Arena arena) {
        this.arena = arena;
        this.arenaImageFactory = new ArenaImageFactory();
        this.shipImageFactory = new ShipImageFactory();
        this.enemyImageFactory = new EnemyImageFactory();
        this.shotImageFactory = new ShotImageFactory();
        this.defaultFragmentImageFactory = new DefaultFragmentImageFactory();
        this.backgroundColor = new TextColor.RGB(128, 128, 128);
        this.boxImageRenderer = new BoxImageRenderer();
    }

    public void render(TextGraphics graphics) {
        boxImageRenderer.setBox(arena);
        boxImageRenderer.setImage(arenaImageFactory.createTextImage(new ImageInfo(backgroundColor)));
        boxImageRenderer.render(graphics);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(3,1,"HEALTH", SGR.BOLD);
        graphics.putString(10,1,Integer.toString(arena.getShip().getHealthyBehavior().getCurrentHealth()), SGR.BOLD);
        graphics.putString(3,23,"ESC TO MENU", SGR.BOLD);

        boxImageRenderer.setBox(arena.getShip());
        boxImageRenderer.setImage(shipImageFactory.createTextImage(new ImageInfo(backgroundColor)));
        boxImageRenderer.render(graphics);

        for (Enemy enemy : arena.getEnemies()) {
            boxImageRenderer.setBox(enemy);
            boxImageRenderer.setImage(enemyImageFactory.createTextImage(new ImageInfo(enemy.getImageName(), backgroundColor)));
            boxImageRenderer.render(graphics);
        }
        for (Wall wall : arena.getWalls()) {
            for (Fragment fragment : wall.getFragments()) {
                boxImageRenderer.setBox(fragment);
                boxImageRenderer.setImage(defaultFragmentImageFactory.createTextImage(new ImageInfo(backgroundColor)));
                boxImageRenderer.render(graphics);
            }
        }
        for (Shot shot : arena.getShots()) {
            boxImageRenderer.setBox(shot);
            boxImageRenderer.setImage(shotImageFactory.createTextImage(new ImageInfo(shot.getImageName(), backgroundColor)));
            boxImageRenderer.render(graphics);
        }
    }
}
