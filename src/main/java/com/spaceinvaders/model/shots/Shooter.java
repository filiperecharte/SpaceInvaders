package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.geometry.Position;

public interface Shooter {
    Position getShootPosition();
    Object getShotType();
}
