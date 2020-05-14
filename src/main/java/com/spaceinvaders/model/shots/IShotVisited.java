package com.spaceinvaders.model.shots;

public interface IShotVisited {
    void accept(IShotsVisitor visitor);
}
