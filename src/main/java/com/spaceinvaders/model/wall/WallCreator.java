package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public interface WallCreator {
    Wall build(Position position);
}
