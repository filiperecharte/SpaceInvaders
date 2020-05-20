package com.spaceinvaders.model;

import com.spaceinvaders.model.geometry.Size;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoxDilator {
    public Size dilate(List<? extends Box> boxes) {
        Box maxBoxX = Collections.max(boxes, Comparator.comparing(b -> b.getPosition().getX() + b.getSize().getWidth()));
        Box maxBoxY = Collections.max(boxes, Comparator.comparing(b -> b.getPosition().getY() + b.getSize().getHeight()));
        int width = maxBoxX.getPosition().getX() + maxBoxX.getSize().getWidth();
        int height = maxBoxY.getPosition().getY() + maxBoxY.getSize().getHeight();
        return new Size(width, height);
    }
}
