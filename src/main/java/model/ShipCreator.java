package model;

import model.geometry.Position;
import model.geometry.Size;
import model.image.Image;
import model.image.Pixel;

public class ShipCreator {

    public Ship createShip() {
        Image shipImage = new Image();

        shipImage.addPixel(new Pixel(new Position(0, 0), '/'));
        shipImage.addPixel(new Pixel(new Position(1, 0), '-'));
        shipImage.addPixel(new Pixel(new Position(2, 0), '^'));
        shipImage.addPixel(new Pixel(new Position(3, 0), '-'));
        shipImage.addPixel(new Pixel(new Position(4, 0), '\\'));

        shipImage.setColor("#FFFF33");
        shipImage.setBold(true);

        return new Ship(new Position(30, 22), new Size(5, 1), shipImage);
    }
}
