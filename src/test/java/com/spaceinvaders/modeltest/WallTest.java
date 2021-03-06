package com.spaceinvaders.modeltest;

import com.spaceinvaders.exceptions.IllegalArgumentException;
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
        wall = new Wall(new Position(10,10));
    }

    @Test
    public void addFragmentTest() throws IllegalArgumentException {
        wall.addFragment(new Fragment(new Position(10,20), new Size(1,2)));
        wall.addFragment(new Fragment(new Position(20,50), new Size(2,4)));
        wall.addFragment(new Fragment(new Position(30,90), new Size(3,6)));
        wall.addFragment(new Fragment(new Position(44,80), new Size(4,8)));

        assertEquals(4, wall.getFragments().size());
    }

    @Test
    public void removeFragmentTest() throws IllegalArgumentException {
        wall.addFragment(new Fragment(new Position(1,2),new Size(1,1)));
        wall.addFragment(new Fragment(new Position(2,2),new Size(1,1)));
        wall.addFragment(new Fragment(new Position(3,2),new Size(1,1)));
        wall.addFragment(new Fragment(new Position(4,2),new Size(1,1)));
        wall.removeFragment(new Fragment(new Position(1,2),new Size(1,1)));

        assertEquals(3, wall.getFragments().size());

        assertEquals(2,wall.getFragments().get(0).getPosition().getX());
        assertEquals(2,wall.getFragments().get(0).getPosition().getY());

    }
}
