package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.shots.IShotsVisitor;
import com.spaceinvaders.model.shots.ShipShot;
import com.spaceinvaders.model.shots.enemyshotvariants.*;
import com.spaceinvaders.view.lanternaview.imagesfactories.EnemyShotImageFactory;
import com.spaceinvaders.view.lanternaview.imagesfactories.ShipShotImageFactory;
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
        new BoxImageRenderer(shipShot, new ShipShotImageFactory().createTextImage(shipShot,backgroundColor)).render(graphics);
    }

    @Override
    public void visit(WeakShot weakShot) {
        new BoxImageRenderer(weakShot, new EnemyShotImageFactory().createTextImage(weakShot,backgroundColor)).render(graphics);
    }

    @Override
    public void visit(ImmatureShot immatureShot) {
        new BoxImageRenderer(immatureShot, new EnemyShotImageFactory().createTextImage(immatureShot, backgroundColor)).render(graphics);
    }

    @Override
    public void visit(SlickShot slickShot) {
        new BoxImageRenderer(slickShot, new EnemyShotImageFactory().createTextImage(slickShot,backgroundColor)).render(graphics);
    }

    @Override
    public void visit(PowerfulShot powerfulShot) {
        new BoxImageRenderer(powerfulShot, new EnemyShotImageFactory().createTextImage(powerfulShot,backgroundColor)).render(graphics);
    }

    @Override
    public void visit(LegendaryShot legendaryShot) {
        new BoxImageRenderer(legendaryShot, new EnemyShotImageFactory().createTextImage(legendaryShot,backgroundColor)).render(graphics);
    }
}
