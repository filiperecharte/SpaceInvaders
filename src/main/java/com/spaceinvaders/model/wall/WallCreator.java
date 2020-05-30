package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.geometry.Position;

public interface WallCreator {
    Wall build(Position position);
}
