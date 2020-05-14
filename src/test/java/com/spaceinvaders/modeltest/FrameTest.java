package com.spaceinvaders.modeltest;

import com.spaceinvaders.model.Frame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class FrameTest {

    private Image imageMock;

    @Before
    public void setUp() {
        imageMock = Mockito.mock(Image.class);
        when(imageMock.getSize()).thenReturn(new Size(10, 20));
    }

    @Test
    public void perfectlyOverlappedTest() {
        Frame frame1 = new Frame(new Position(0, 0), new Size(10, 20), imageMock);
        Frame frame2 = new Frame(new Position(0, 0), new Size(10, 30), imageMock);

        assertTrue(frame1.isPerfectlyOverlapped());
        assertFalse(frame2.isPerfectlyOverlapped());
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalArgumentTest1() {
        Frame frame = new Frame(new Position(0, 0), new Size(10, 19), imageMock);
    }

    @Test (expected = IllegalArgumentException.class)
    public void IllegalArgumentTest2() {
        Frame frame = new Frame(new Position(0, 0), new Size(9, 20), imageMock);
    }
}
