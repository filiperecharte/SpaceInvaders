package com.spaceinvaders.model.pools.shotpools;

import com.spaceinvaders.model.IShotsVisitor;

public interface IShotPoolVisited {
    void accept(IShotsVisitor visitor);
}
