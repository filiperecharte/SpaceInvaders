package com.spaceinvaders.model.behaviors;

import com.spaceinvaders.exceptions.IllegalArgumentException;

public class AttackBehavior {
    private int attackFactor;

    public AttackBehavior(int attackFactor) throws IllegalArgumentException {
        if (attackFactor < 1 || attackFactor > 100)
            throw new IllegalArgumentException("attackFactor must be between 1 and 100");
        this.attackFactor = attackFactor;
    }

    public int getAttackFactor() {
        return attackFactor;
    }

    public void setAttackFactor(int attackFactor) {
        this.attackFactor = attackFactor;
    }

    public boolean readyToShoot(int value) {
        return value % attackFactor == 0;
    }
}
