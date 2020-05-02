package view;

import model.Ship;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ShipRenderer implements Renderer {
    private Ship ship;

    public ShipRenderer(Ship ship) {
        this.ship = ship;
    }

    public void render(TextGraphics graphics) {
        new ImageRenderer(ship.getImage()).render(graphics);
    }
}
