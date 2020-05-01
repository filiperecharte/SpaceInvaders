package model;

import model.geometry.Position;
import model.geometry.Size;
import model.image.Image;
import model.image.Pixel;

public class ShipCreator {

    public Ship createShip() {
        Image shipImage = new Image("#FFFF33");
        shipImage.addPixel(new Pixel(new Position(0, 0), '#'));
        return new Ship(new Position(30, 22), new Size(5, 1), shipImage);
    }
}
