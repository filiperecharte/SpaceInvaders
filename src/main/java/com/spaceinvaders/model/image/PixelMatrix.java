package com.spaceinvaders.model.image;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;

import java.util.ArrayList;

public class PixelMatrix {
    private ArrayList<Pixel> pixels;

    public PixelMatrix() {
        pixels = new ArrayList<>();
    }

    public ArrayList<Pixel> getPixels(){
        return pixels;
    }

    public void addPixel(Pixel pixel) throws IllegalArgumentException {
        if (findPixelIndex(pixel.getPosition()) != -1)
            throw new IllegalArgumentException("Pixel already exists!");
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

    public void removePixel(Position position) throws IllegalArgumentException {
        int pixelIndex = findPixelIndex(position);
        if (pixelIndex == -1) throw new IllegalArgumentException("Pixel with given position not found!");
        pixels.remove(pixelIndex);
    }

    public void changePixelCharacter(Position position, char newChar) throws IllegalArgumentException {
        int pixelIndex = findPixelIndex(position);
        if (pixelIndex == -1) throw new IllegalArgumentException("Pixel with given position not found!");
        pixels.get(pixelIndex).setCharacter(newChar);
    }
}
