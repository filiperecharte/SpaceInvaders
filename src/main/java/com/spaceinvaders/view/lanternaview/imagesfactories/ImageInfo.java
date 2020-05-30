package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.TextColor;

public class ImageInfo {
    private String imageName;
    private TextColor backgroundColor;

    public ImageInfo(String imageName, TextColor backgroundColor) {
        this.imageName = imageName;
        this.backgroundColor = backgroundColor;
    }

    public ImageInfo(TextColor backgroundColor) {
        this.imageName = "";
        this.backgroundColor = backgroundColor;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String objectName) {
        this.imageName = objectName;
    }

    public TextColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(TextColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
