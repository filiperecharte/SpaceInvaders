package model;

import model.geometry.Position;
import model.geometry.Size;
import model.image.Image;

public class Ship extends Box {
    private boolean isAlive;
    //private String design;
    private Image image;

    public Ship(Position position, Size size, Image image){
        super(position, size);
        //design="/-^-\\";
        this.image = image;
        isAlive=true;
    }

    //public String getDesign() {return design;}

    public Image getImage() {
        return image;
    }

    public void setImage(Image newImage) {
        this.image = newImage;
    }

    public void update() {
        this.image.setPosition(this.position);
    }

}
