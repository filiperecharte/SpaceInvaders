package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PixelMatrixTest {
    private PixelMatrix pixelMatrix;

    @Before
    public void setUp() {
        pixelMatrix = new PixelMatrix();

        try {
            pixelMatrix.addPixel(new Pixel(new Position(5, 5), '#'));
            pixelMatrix.addPixel(new Pixel(new Position(6, 19), 'p'));
            pixelMatrix.addPixel(new Pixel(new Position(3, 45), 'x'));
            pixelMatrix.addPixel(new Pixel(new Position(23, 48), '8'));
            pixelMatrix.addPixel(new Pixel(new Position(34, 12), 'y'));
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void IllegalArgumentTest() {
        pixelMatrix.addPixel(new Pixel(new Position(6, 19), 'p'));
    }*/

    @Test
    public void addPixelTest() {

        assertEquals(5,pixelMatrix.getPixels().size());
        assertEquals('#',pixelMatrix.getPixels().get(0).getCharacter());
        assertEquals('p',pixelMatrix.getPixels().get(1).getCharacter());
        assertEquals('y',pixelMatrix.getPixels().get(4).getCharacter());
    }

    @Test
    public void removePixelTest() throws IllegalArgumentException {
        assertEquals(5, pixelMatrix.getPixels().size());
        pixelMatrix.removePixel(new Position(23,48));
        assertEquals(4,pixelMatrix.getPixels().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void removePixelExceptionTest() throws IllegalArgumentException {
        pixelMatrix.removePixel(new Position(5,6));
    }

    @Test
    public void changePixelCharacterTest() throws IllegalArgumentException {

        pixelMatrix.changePixelCharacter(new Position(23,48),'U');
        assertEquals('U',pixelMatrix.getPixels().get(pixelMatrix.findPixelIndex(new Position(23,48))).getCharacter());

    }

    @Test (expected = IllegalArgumentException.class)
    public void changePixelCharacterExceptionTest() throws IllegalArgumentException {
        pixelMatrix.changePixelCharacter(new Position(5,6),'U');
    }
}
