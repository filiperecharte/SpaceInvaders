package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WallTest {
    private Wall wall;

    @Before
    public void setUp() {
        wall = new Wall(new Position(10,10), new Size(13,13));
    }

    @Test
    public void addFragmentTest() {
        wall.addFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(2,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(3,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(4,2),new Size(1,1),'#'));

        assertEquals(4, wall.getFragments().size());
        assertEquals(4, wall.getImage().getPixelMatrix().getPixels().size());
    }

    @Test
    public void removeFragmentTest() {
        wall.addFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(2,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(3,2),new Size(1,1),'#'));
        wall.addFragment(new Fragment(new Position(4,2),new Size(1,1),'#'));
        wall.removeFragment(new Fragment(new Position(1,2),new Size(1,1),'#'));

        assertEquals(3, wall.getFragments().size());
        assertEquals(3, wall.getImage().getPixelMatrix().getPixels().size());
    }
}
