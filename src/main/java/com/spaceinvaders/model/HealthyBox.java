package com.spaceinvaders.model;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.box.Box;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class HealthyBox extends Box {
    private int totalHealth;
    private int currentHealth;

    public HealthyBox(Position position, Size size, int health) throws IllegalArgumentException {
        super(position, size);
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
