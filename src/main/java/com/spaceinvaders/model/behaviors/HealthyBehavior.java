package com.spaceinvaders.model.behaviors;

import com.spaceinvaders.exceptions.IllegalArgumentException;

public class HealthyBehavior {
    private int totalHealth;
    private int currentHealth;

    public HealthyBehavior(int health) throws IllegalArgumentException {
        if (health <= 0)
            throw new IllegalArgumentException("Health must be positive");
        this.totalHealth = health;
        this.currentHealth = health;
    }

    public HealthyBehavior() {
        this.totalHealth = 1;
        this.currentHealth = 1;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void decrementHealth(int value) {
        this.currentHealth -= value;
    }

    public boolean isDead() {
        return this.currentHealth <= 0;
    }
}
