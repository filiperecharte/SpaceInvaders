package com.spaceinvaders.model.shots;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;

public class ShipShot extends Shot implements IShotVisited {

    public ShipShot() {
        super(new Position(0, 0), new Size(1, 1));
        this.movableBehavior = new MovableBehavior(new Vector(0, -1));
        try {
            this.damageBehavior = new DamageBehavior(1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void accept(IShotsVisitor visitor) {
        visitor.visit(this);
    }
}
