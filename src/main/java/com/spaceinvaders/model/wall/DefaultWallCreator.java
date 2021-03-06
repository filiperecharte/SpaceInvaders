package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

public class DefaultWallCreator implements WallCreator {

    @Override
    public Wall build(Position position) {
        Wall wall = new Wall(position);
        for(int x = wall.getPosition().getX()+3; x<= wall.getPosition().getX()+5; x++){
            Fragment fragment = new Fragment(new Position(x, wall.getPosition().getY()-3),new Size(1,1));
            try { wall.addFragment(fragment); } catch (IllegalArgumentException e) { e.printStackTrace(); }
        }
        for(int x = wall.getPosition().getX()+2; x<= wall.getPosition().getX()+6; x++){
            Fragment fragment = new Fragment(new Position(x, wall.getPosition().getY()-2),new Size(1,1));
            try { wall.addFragment(fragment); } catch (IllegalArgumentException e) { e.printStackTrace(); }
        }
        for(int x = wall.getPosition().getX()+1; x<= wall.getPosition().getX()+7; x++){
            Fragment fragment = new Fragment(new Position(x, wall.getPosition().getY()-1),new Size(1,1));
            try { wall.addFragment(fragment); } catch (IllegalArgumentException e) { e.printStackTrace(); }
        }
        for(int x = wall.getPosition().getX(); x<= wall.getPosition().getX()+8; x++){
            Fragment fragment = new Fragment(new Position(x, wall.getPosition().getY()),new Size(1,1));
            try { wall.addFragment(fragment); } catch (IllegalArgumentException e) { e.printStackTrace(); }
        }
        return wall;
    }

}
