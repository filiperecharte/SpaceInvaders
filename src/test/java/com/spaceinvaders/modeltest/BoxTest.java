package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BoxTest {

    @Test
    public void CointainsTest() {
        Box box = new Box(new Position(10, 20), new Size(20, 20));

        assertFalse(box.contain(new Position(5,5)));
        assertFalse(box.contain(new Position(30,52)));
        assertTrue(box.contain(new Position(16,30)));
    }
}
