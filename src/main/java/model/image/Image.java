package model.image;

import model.Box;
import model.geometry.Position;
import model.geometry.Size;

import java.util.ArrayList;

public class Image extends Box {

    private ArrayList<Pixel> matrix;

    public Image() {
        super(new Position(0, 0), new Size(0, 0));
        matrix = new ArrayList<>();
    }

    public void addPixel(Pixel pixel) {
        matrix.add(pixel);
    }

    public int findPixelIndex(Position position) {
        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.get(i).getPosition().equals(position)) {
                return i;
            }
        }
        return -1;
    }

    public void removePixel(Position position) {
        matrix.remove(findPixelIndex(position));
    }

    public void changePixelCharacter(Position position, char newChar) {
        matrix.get(findPixelIndex(position)).setCharacter(newChar);
    }

    public int calculateMaxPixelX() {
        int maxX = Integer.MIN_VALUE;

        for (Pixel pixel : matrix) {
            if (pixel.getPosition().getX() > maxX) {
                maxX = pixel.getPosition().getX();
            }
        }

        return maxX;
    }

    public int calculateMaxPixelY() {
        int maxY = Integer.MIN_VALUE;

        for (Pixel pixel : matrix) {
            if (pixel.getPosition().getY() > maxY) {
                maxY = pixel.getPosition().getX();
            }
        }

        return maxY;
    }

    public void updateSize() {
        this.size.setWidth(calculateMaxPixelX());
        this.size.setHeight(calculateMaxPixelY());
    }
}
