package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.enemy.Enemy;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import com.spaceinvaders.view.lanternaview.imagesfactories.*;
import com.spaceinvaders.view.lanternaview.imagesrederers.BoxImageRenderer;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class PlayRenderer implements Renderer {
    private Arena arena;

    public PlayRenderer(Arena arena) {
        this.arena = arena;
    }

    public void render(TextGraphics graphics) {

        TextColor backgroundColor = new TextColor.RGB(128, 128, 128);

        new BoxImageRenderer(arena, new ArenaImageFactory().createTextImage(backgroundColor)).render(graphics);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(3,1,"LIFES", SGR.BOLD);
        graphics.putString(9,1,Integer.toString(arena.getShip().getHealthyBehavior().getCurrentHealth()), SGR.BOLD);

        new BoxImageRenderer(arena.getShip(), new ShipImageFactory().createTextImage(backgroundColor)).render(graphics);
        for (Enemy enemy : arena.getEnemies()) {
            new BoxImageRenderer(enemy, new EnemyImageFactory().makeEnemyImage(enemy,backgroundColor)).render(graphics);
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
