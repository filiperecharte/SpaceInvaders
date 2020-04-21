package View;

import Model.Ship;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ShipRenderer implements Renderer {
    private Ship ship;

    public ShipRenderer(Ship ship) {
        this.ship = ship;
    }

    public void render(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(ship.getPosition().getX(), ship.getPosition().getY()), ship.getDesign());
    }
}
