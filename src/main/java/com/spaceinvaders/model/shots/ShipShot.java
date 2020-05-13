package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.ImageCreator;
import com.spaceinvaders.model.image.Pixel;

public class ShipShot extends Shot implements IShotVisited, ImageCreator {
    public ShipShot(Position position) {
        super(position, new Size(1, 1), new Image(), 1, new Vector(0, -1));
        this.setImage(createImage());
    }

    public ShipShot() {
        super(new Position(0, 0), new Size(1, 1), new Image(), 1, new Vector(0, -1));
        this.setImage(createImage());
    }

    public Image createImage() {
        Image image = new Image();

        image.addPixel(new Pixel(new Position(0, 0), '.'));

        image.setColor("#000000");
        image.setBold(true);

        return image;
    }

    @Override
    public void accept(IShotsVisitor visitor) {
        visitor.visit(this);
    }
}
