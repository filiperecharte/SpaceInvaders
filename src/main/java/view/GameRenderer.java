package view;

import model.arena.Arena;
import model.Ship;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GameRenderer implements Renderer{
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
