package com.spaceinvaders.model.shots;

import com.spaceinvaders.model.IShotVisited;
import com.spaceinvaders.model.IShotsVisitor;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.ImageCreator;

public class EnemyShot implements IShotVisited, ImageCreator {

    @Override
    public Image createImage() {
        return null;
    }

    @Override
    public void accept(IShotsVisitor visitor) {
        visitor.visit(this);
    }
}
