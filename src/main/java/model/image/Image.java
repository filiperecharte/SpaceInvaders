package model.image;

import model.Box;
import model.geometry.Position;
import model.geometry.Size;
import model.geometry.Translaction;
import model.geometry.Vector;

import java.util.ArrayList;

public class Image extends Box {

    private ArrayList<Pixel> pixels;
    private String color;
    private boolean bold;

    public Image() {
        super(new Position(0, 0), new Size(0, 0));
        this.color = "#000000";
        this.bold = false;
        this.pixels = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBold() {
        return this.bold;
    }

    public void setBold(boolean newBold) {
        this.bold = newBold;
    }

    public ArrayList<Pixel> getPixels(){
        return pixels;
    }

    public void addPixel(Pixel pixel) {
        pixels.add(pixel);
    }

    public int findPixelIndex(Position position) {
        for (int i = 0; i < pixels.size(); i++) {
            if (pixels.get(i).getPosition().equals(position)) {
                return i;
            }
        }
        return -1;
    }

    public void removePixel(Position position) {
        pixels.remove(findPixelIndex(position));
    }

    public void changePixelCharacter(Position position, char newChar) {
        pixels.get(findPixelIndex(position)).setCharacter(newChar);
    }

    public int calculateMaxPixelX() {
        int maxX = Integer.MIN_VALUE;

        for (Pixel pixel : pixels) {
            if (pixel.getPosition().getX() > maxX) {
                maxX = pixel.getPosition().getX();
            }
        }

        return maxX;
    }

    public int calculateMaxPixelY() {
        int maxY = Integer.MIN_VALUE;

        for (Pixel pixel : pixels) {
            if (pixel.getPosition().getY() > maxY) {
                maxY = pixel.getPosition().getY();
            }
        }

        return maxY;
    }

    public void updateSize() {
        this.size.setWidth(calculateMaxPixelX());
        this.size.setHeight(calculateMaxPixelY());
    }

    @Override
    public void setPosition(Position position) {

        Vector v = new Vector(this.position, position);

        for (Pixel pixel : pixels) {
            Translaction translaction = new Translaction(pixel.getPosition(), v);
            pixel.setPosition(translaction.apply());
        }

        super.setPosition(position);
    }
}
