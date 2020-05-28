package com.spaceinvaders.model.shots.enemyshotvariants;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.geometry.Vector;
import com.spaceinvaders.model.shots.IShotVisited;
import com.spaceinvaders.model.shots.IShotsVisitor;
import com.spaceinvaders.model.shots.Shot;

public class SlickShot extends Shot implements IShotVisited {

    public SlickShot() {
        super(new Position(0, 0), new Size(1, 1));
        this.movableBehavior = new MovableBehavior(new Vector(0, 1));
        try {
            this.damageBehavior = new DamageBehavior(3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void accept(IShotsVisitor visitor) {
        visitor.visit(this);
    }
}
