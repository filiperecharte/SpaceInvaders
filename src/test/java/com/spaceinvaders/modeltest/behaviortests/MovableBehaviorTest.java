package com.spaceinvaders.modeltest.behaviortests;

import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Vector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class MovableBehaviorTest {
    private MovableBehavior movableBehavior;
    private Vector vectorMock;

    @Before
    public void setUp() {
        vectorMock = Mockito.mock(Vector.class);
        when(vectorMock.getX()).thenReturn(1);
        when(vectorMock.getY()).thenReturn(-2);
        movableBehavior = new MovableBehavior(vectorMock);
    }

    @Test
    public void invertVelocityTest() {
        ArgumentCaptor<Integer> valueCaptureX = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> valueCaptureY = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(vectorMock).setX(valueCaptureX.capture());
        doNothing().when(vectorMock).setY(valueCaptureY.capture());
        movableBehavior.invertVelocity();
        assertEquals(Integer.valueOf(-1), valueCaptureX.getValue());
        assertEquals(Integer.valueOf(2), valueCaptureY.getValue());
    }
}
