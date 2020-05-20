package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class ShipShot extends Shot implements IShotVisited {

    public ShipShot() {
        super(new Position(0, 0), new Size(1, 1), new Vector(0, -1), 1);
    }

    @Override
    public void accept(IShotsVisitor visitor) {
        visitor.visit(this);
    }
}
