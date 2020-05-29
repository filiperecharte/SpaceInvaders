package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;

public interface ImageFactory {
    TextImage createTextImage(Object object, TextColor backgroundColor);
}
