package com.spaceinvaders.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.model.wall.DefaultWallCreator;
import com.spaceinvaders.model.wall.Wall;

public class WallRenderer implements Renderer{
    private Wall wall;

    public WallRenderer(Wall wall) {this.wall=wall; }
    public void render(TextGraphics graphics) {
        new ImageRenderer(wall.getImage()).render(graphics);
    }
}
