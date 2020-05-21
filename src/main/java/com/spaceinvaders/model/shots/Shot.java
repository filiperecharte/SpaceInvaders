package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Shot extends Box implements IElementVisited {
    protected DamageBehavior damageBehavior;
    protected MovableBehavior movableBehavior;

    public Shot(Position position, Size size, MovableBehavior movableBehavior, DamageBehavior damageBehavior) {
        super(position, size);
        this.movableBehavior = movableBehavior;
        this.damageBehavior = damageBehavior;
    }

    public Shot(Position position, Size size) {
        super(position, size);
    }

    public MovableBehavior getMovableBehavior() {
        return movableBehavior;
    }

    public void setMovableBehavior(MovableBehavior movableBehavior) {
        this.movableBehavior = movableBehavior;
    }

    public DamageBehavior getDamageBehavior() {
        return damageBehavior;
    }

    public void setDamageBehavior(DamageBehavior damageBehavior) {
        this.damageBehavior = damageBehavior;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
