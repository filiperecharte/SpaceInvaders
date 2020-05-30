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
    private String name, imageName;

    public Shot(Position position, Size size, String name, String imageName) {
        super(position, size);
        this.name = name;
        this.imageName = imageName;
    }

    public Shot() {
        super(new Position(0, 0), new Size(1, 1));
        damageBehavior = new DamageBehavior();
        movableBehavior = new MovableBehavior();
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

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
