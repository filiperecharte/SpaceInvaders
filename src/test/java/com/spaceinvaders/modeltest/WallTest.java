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

    @Before
    public void setUp() {
        wall = new Wall(new Position(10,10));
    }

    @Test
    public void addFragmentTest() throws IllegalArgumentException {
        wall.addFragment(new Fragment(new Position(10,20), new Size(1,2)));
        wall.addFragment(new Fragment(new Position(20,50), new Size(2,4)));
        wall.addFragment(new Fragment(new Position(30,90), new Size(3,6)));
        wall.addFragment(new Fragment(new Position(44,80), new Size(4,8)));

        assertEquals(4, wall.getFragments().size());
        assertEquals(new Size());
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
