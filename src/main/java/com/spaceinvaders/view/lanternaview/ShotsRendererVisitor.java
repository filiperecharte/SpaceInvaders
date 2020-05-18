package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.shots.EnemyShot;
import com.spaceinvaders.model.shots.IShotsVisitor;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.view.lanternaview.imagesfactories.DefaultFragmentImageFactory;
import com.spaceinvaders.view.lanternaview.imagesfactories.EnemyShotImageFactory;
import com.spaceinvaders.view.lanternaview.imagesrederers.BoxImageRenderer;

public class ShotsRendererVisitor implements IShotsVisitor {
    private TextColor backgroundColor;
    private TextGraphics graphics;

    public ShotsRendererVisitor(TextColor backgroundColor, TextGraphics graphics) {
        this.backgroundColor = backgroundColor;
        this.graphics = graphics;
    }

    @Override
    public void visit(ShipShot shipShot) {
        new BoxImageRenderer(shipShot, new EnemyShotImageFactory().createTextImage(backgroundColor)).render(graphics);
    }

    @Override
    public void visit(EnemyShot enemyShot) {
        new BoxImageRenderer(enemyShot, new EnemyShotImageFactory().createTextImage(backgroundColor)).render(graphics);
    }
}
