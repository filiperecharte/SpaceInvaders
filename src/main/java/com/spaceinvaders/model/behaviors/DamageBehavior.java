package com.spaceinvaders.model.behaviors;

import com.spaceinvaders.exceptions.IllegalArgumentException;

public class DamageBehavior {
    private int damage;

    public DamageBehavior(int damage) throws IllegalArgumentException {
        if (damage <= 0)
            throw new IllegalArgumentException("Damage must be positive");
        this.damage = damage;
    }

    public DamageBehavior() {
        this.damage = 1;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void applyDamage(HealthyBehavior behavior) {
        behavior.decrementHealth(damage);
    }
}
