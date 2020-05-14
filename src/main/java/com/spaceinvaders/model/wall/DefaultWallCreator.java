package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;

public class DefaultWallCreator implements WallCreator {
    private Wall wall;

    @Override
    public Wall build(Position position, Size size) {
        wall = new Wall(position, size, new Image());
        for(int x=wall.getPosition().getX()+3; x<=wall.getPosition().getX()+5;x++){
            wall.addFragment(new Fragment(new Position(x,wall.getPosition().getY()-3),new Size(1,1),'#'));
    }
        for(int x=wall.getPosition().getX()+2; x<=wall.getPosition().getX()+6;x++){
            wall.addFragment(new Fragment(new Position(x,wall.getPosition().getY()-2),new Size(1,1),'#'));
        }
        for(int x=wall.getPosition().getX()+1; x<=wall.getPosition().getX()+7;x++){
            wall.addFragment(new Fragment(new Position(x,wall.getPosition().getY()-1),new Size(1,1),'#'));
        }
        for(int x=wall.getPosition().getX(); x<=wall.getPosition().getX()+8;x++){
            wall.addFragment(new Fragment(new Position(x,wall.getPosition().getY()),new Size(1,1),'#'));
        }
        return wall;
    }

}
