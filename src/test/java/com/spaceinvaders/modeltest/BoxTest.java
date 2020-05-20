package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BoxTest {

    @Test
    public void containsElementTest() {
        Box box = new Box(new Position(10, 20), new Size(20, 20));

        assertFalse(box.containPos(new Position(5,5)));
        assertFalse(box.containPos(new Position(30,52)));
        assertTrue(box.containPos(new Position(16,30)));
    }

    @Test
    public void containsBoxTest() {
        Box box = new Box(new Position(100, 100), new Size(100, 70));

        assertFalse(box.containBox(new Box(new Position(50, 50), new Size(100, 50))));
        assertFalse(box.containBox(new Box(new Position(50, 50), new Size(200, 200))));
        assertTrue(box.containBox(new Box(new Position(120, 120), new Size(50, 50))));
    }
}
