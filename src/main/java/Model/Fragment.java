package model;

import model.geometry.Position;
import model.geometry.Size;

public class Fragment extends Box{
    private char design ='#';

    public Fragment(Position position, Size size) {
        super(position, size);
    }

}
