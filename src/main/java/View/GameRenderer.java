package View;

import Model.Arena;
import Model.Ship;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GameRenderer{
    private Arena arena;
    private Ship ship;

    public GameRenderer(Arena arena,Ship ship) {
        this.arena = arena;
        this.ship=ship;
    }

    public void render(TextGraphics graphics) {
        new ArenaRenderer(arena).render(graphics);
        new ShipRenderer(ship).render(graphics);
    }

}
