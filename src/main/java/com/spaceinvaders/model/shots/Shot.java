package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.behaviors.DamageBehavior;
import com.spaceinvaders.model.behaviors.MovableBehavior;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class Shot extends Box implements IElementVisited {
    private DamageBehavior damageBehavior;
    private MovableBehavior movableBehavior;
    private String name;

    public Shot(Position position, Size size, String name) {
        super(position, size);
        this.name = name;
    }

    public Shot() {
        super(new Position(0, 0), new Size(1, 1));
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
