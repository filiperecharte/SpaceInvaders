package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Size;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SizeTest {

    @Test
    public void equalsTest() {
        Size size1 = new Size(10, 20);
        Size size2 = new Size(10, 20);
        Size size3 = new Size(10, 30);
        Size size4 = new Size(0, 0);

        assertTrue(size1.equals(size2));
        assertFalse(size1.equals(size3));
        assertFalse(size1.equals(size4));
    }

    @Test
    public void fitInTest() {
        Size size1 = new Size(10, 20);
        Size size2 = new Size(9, 20);
        Size size3 = new Size(10, 19);
        Size size4 = new Size(10, 20);

        assertTrue(size2.fitIn(size1));
        assertTrue(size3.fitIn(size1));
        assertTrue(size4.fitIn(size1));

        assertFalse(size1.fitIn(size2));
        assertFalse(size1.fitIn(size3));
        assertTrue(size1.fitIn(size4));
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalWidthTest() {
        Size size = new Size(-1, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalHeightTest() {
        Size size = new Size(0, -1);
    }
}
