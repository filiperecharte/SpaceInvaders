package com.spaceinvaders.model.enemy;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public interface EnemyCreator {
    Enemy build(Position position, Size size);
}
