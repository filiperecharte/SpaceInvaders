package view;

import model.arena.Arena;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ArenaRenderer implements Renderer {
    private Arena arena;

    public ArenaRenderer(Arena arena) {
        this.arena=arena;
    }

    public void render(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(arena.getBackgroundColor()));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        new ShipRenderer(arena.getShip()).render(graphics);
    }
}
