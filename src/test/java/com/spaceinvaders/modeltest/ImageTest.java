package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ImageTest {
    private Image image;
    @Before
    public void setUp() {

        ArrayList<Pixel> pixels = new ArrayList<>();

        pixels.add(new Pixel(new Position(5,5),'#'));
        pixels.add(new Pixel(new Position(6,19),'p'));
        pixels.add(new Pixel(new Position(3,45),'x'));
        pixels.add(new Pixel(new Position(23,48),'8'));
        pixels.add(new Pixel(new Position(34,12),'y'));

        PixelMatrix pixelMatrixMock = Mockito.mock(PixelMatrix.class);
        when(pixelMatrixMock.getPixels()).thenReturn(pixels);

        image = new Image();
        image.setPixelMatrix(pixelMatrixMock);

    }

    @Test
    public void imageColorTest() {
        image.setColor("#00FFFF");
        assertEquals("#00FFFF", image.getColor());
    }

    @Test
    public void imageBoldTest() {
        image.setBold(true);
        assertTrue(image.isBold());
    }

    @Test
    public void updateSizeTest() {
        image.updateSize();

        assertEquals(35,image.getSize().getWidth());
        assertEquals(49,image.getSize().getHeight());

    }

    @Test
    public void setPositionTest() {
        Position setPosition = new Position(10, 20);

        image.setPosition(setPosition);

        assertEquals(15, image.getPixelMatrix().getPixels().get(0).getPosition().getX());
        assertEquals(25, image.getPixelMatrix().getPixels().get(0).getPosition().getY());

        assertEquals(16, image.getPixelMatrix().getPixels().get(1).getPosition().getX());
        assertEquals(39, image.getPixelMatrix().getPixels().get(1).getPosition().getY());

        assertEquals(13, image.getPixelMatrix().getPixels().get(2).getPosition().getX());
        assertEquals(65, image.getPixelMatrix().getPixels().get(2).getPosition().getY());

        assertEquals(33, image.getPixelMatrix().getPixels().get(3).getPosition().getX());
        assertEquals(68, image.getPixelMatrix().getPixels().get(3).getPosition().getY());

        assertEquals(44, image.getPixelMatrix().getPixels().get(4).getPosition().getX());
        assertEquals(32, image.getPixelMatrix().getPixels().get(4).getPosition().getY());

        assertEquals(10, image.getPosition().getX());
        assertEquals(20, image.getPosition().getY());
    }
}
