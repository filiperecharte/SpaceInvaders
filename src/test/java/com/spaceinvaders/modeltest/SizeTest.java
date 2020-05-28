package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.geometry.Size;
import org.junit.Test;

import static org.junit.Assert.*;

public class SizeTest {

    @Test
    public void equalsTest() {
        Size size1 = new Size(10, 20);
        Size size2 = new Size(10, 20);
        Size size3 = new Size(10, 30);
        Size size4 = new Size(0, 0);

        assertEquals(size1, size2);
        assertNotEquals(size1, size3);
        assertNotEquals(size1, size4);
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
