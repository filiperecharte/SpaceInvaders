package com.spaceinvaders.model.behaviors;

public class AttackBehavior {
    private int attackFactor;

    public AttackBehavior(int attackFactor) {
        this.attackFactor = attackFactor;
    }

    public int getAttackFactor() {
        return attackFactor;
    }

    public void setAttackFactor(int attackFactor) {
        this.attackFactor = attackFactor;
    }

    public boolean readyToShoot(int randomValue) {
        return randomValue % attackFactor == 0;
    }
}
