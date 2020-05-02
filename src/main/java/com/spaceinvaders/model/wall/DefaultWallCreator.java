package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.Fragment;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class DefaultWallCreator implements WallCreator {
    private Wall wall = new Wall(new Position(10,10),new Size(5,5));

    @Override
    public void build() {
        for(int x=20; x<23;x++){
            wall.addFragment(new Fragment(new Position(x,10),new Size(1,1)));
        }
        for(int x=19; x<24;x++){
            wall.addFragment(new Fragment(new Position(x,11),new Size(1,1)));
        }
        for(int x=18; x<25;x++){
            wall.addFragment(new Fragment(new Position(x,12),new Size(1,1)));
        }
        for(int x=17; x<26;x++){
            wall.addFragment(new Fragment(new Position(x,13),new Size(1,1)));
        }

    }

}
