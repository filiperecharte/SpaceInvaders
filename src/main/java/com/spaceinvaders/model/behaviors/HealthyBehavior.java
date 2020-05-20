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

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void incrementHealth(int health) {
        this.currentHealth += health;
    }

    public void decrementHealth(int health) {
        this.currentHealth -= health;
    }

    public boolean isDead() {
        return this.currentHealth == 0;
    }
}
