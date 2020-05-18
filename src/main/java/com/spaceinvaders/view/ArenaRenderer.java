package com.spaceinvaders.view;

import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class ArenaRenderer implements Renderer {
    private Arena arena;

    public ArenaRenderer(Arena arena) {
        this.arena=arena;
    }

    public void render(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(arena.getBackgroundColor()));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getSize().getWidth(), arena.getSize().getHeight()), ' ');
    }
}
