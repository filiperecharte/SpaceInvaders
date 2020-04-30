package model;

import model.geometry.Position;
import model.geometry.Size;

public class Ship extends Box {
    private boolean isAlive;
    private String design;

    public Ship(Position position, Size size){
        super(position, size);
        design="/-^-\\";
        isAlive=true;
    }

    public String getDesign() {return design;}

}
