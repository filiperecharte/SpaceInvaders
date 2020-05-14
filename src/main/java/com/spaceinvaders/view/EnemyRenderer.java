package com.spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.enemy.Enemy;

public class EnemyRenderer implements Renderer{
    private Enemy enemy;

    public EnemyRenderer(Enemy enemy) {this.enemy=enemy; }
    public void render(TextGraphics graphics) {
        new ImageRenderer(enemy.getImage()).render(graphics);
    }
}
