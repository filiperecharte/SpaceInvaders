package com.spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class ShotRenderer implements Renderer {
    private Shot shot;

    public ShotRenderer(Shot shot) {
        this.shot = shot;
    }

    public void render(TextGraphics graphics) {
        new ImageRenderer(shot.getImage()).render(graphics);
    }
}
