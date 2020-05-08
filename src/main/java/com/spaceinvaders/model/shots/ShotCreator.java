package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public interface ShotCreator {
    Shot create(Position position, Size size);
}
