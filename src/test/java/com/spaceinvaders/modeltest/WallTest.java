package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.image.PixelMatrix;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WallTest {
    private Wall wall;
    private Image mockImage;
    private PixelMatrix mockPixelMatrix;

    @Before
    public void setUp() {
        mockImage = Mockito.mock(Image.class);
        mockPixelMatrix = Mockito.mock(PixelMatrix.class);

        wall = new Wall(new Position(10,10), new Size(13,13), mockImage);

        ArrayList<Pixel> pixels = new ArrayList<>();
        pixels.add(new Pixel(new Position(1,2),'#'));
        pixels.add(new Pixel(new Position(2,2),'#'));
        pixels.add(new Pixel(new Position(3,2),'#'));
        pixels.add(new Pixel(new Position(4,2),'#'));

        when(mockImage.getPixelMatrix()).thenReturn(mockPixelMatrix);
        when(mockPixelMatrix.getPixels()).thenReturn(pixels);
    }

    @Test
    public void addFragmentTest() throws IllegalArgumentException {
        wall.addFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(2,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(3,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(4,2),new Size(1,1),'#'));

        assertEquals(4, wall.getFragments().size());

        ArgumentCaptor<Pixel> valueCaptor = ArgumentCaptor.forClass(Pixel.class);
        verify(mockPixelMatrix, times(4)).addPixel(valueCaptor.capture());

        List<Pixel> values = valueCaptor.getAllValues();

        assertEquals((new Position(1,2)).getX(),values.get(0).getPosition().getX());
        assertEquals((new Position(1,2)).getY(),values.get(0).getPosition().getY());

        assertEquals((new Position(2,2)).getX(),values.get(1).getPosition().getX());
        assertEquals((new Position(2,2)).getY(),values.get(1).getPosition().getY());

        assertEquals((new Position(3,2)).getX(),values.get(2).getPosition().getX());
        assertEquals((new Position(3,2)).getY(),values.get(2).getPosition().getY());

        assertEquals((new Position(4,2)).getX(),values.get(3).getPosition().getX());
        assertEquals((new Position(4,2)).getY(),values.get(3).getPosition().getY());
    }

    @Test
    public void removeFragmentTest() throws IllegalArgumentException {
        wall.addFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(2,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(3,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(4,2),new Size(1,1),'#'));
        wall.removeFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));

        assertEquals(3, wall.getFragments().size());

        ArgumentCaptor<Position> valueCaptor = ArgumentCaptor.forClass(Position.class);
        verify(mockPixelMatrix, times(1)).removePixel(valueCaptor.capture());

        List<Position> values = valueCaptor.getAllValues();

        assertEquals((new Position(1,2)).getX(),values.get(0).getX());
        assertEquals((new Position(1,2)).getY(),values.get(0).getY());

    }
}
