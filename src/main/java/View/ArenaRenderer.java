package View;

import Model.Arena;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.w3c.dom.ls.LSResourceResolver;

public class ArenaRenderer implements Renderer {
    private Arena arena;

    public ArenaRenderer(Arena arena) {
        this.arena=arena;
    }

    public void render(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#92a8d1"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        new ShipRenderer(arena.getShip()).render(graphics);
    }
}
