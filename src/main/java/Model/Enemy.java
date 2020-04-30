package Model;

import Model.geometry.Position;
import Model.geometry.Size;

public class Enemy extends Box {
    private Position position;
    private boolean isAlive;

    public Enemy(Position position, Size size) {
        super(position, size);
        isAlive=true;
    }

}