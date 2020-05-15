package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

public class DefaultWallCreator implements WallCreator {
    private Wall wall;

    @Override
    public Wall build(Position position, Size size) {
        wall = new Wall(position, size);
        for(int x=wall.getPosition().getX()+3; x<=wall.getPosition().getX()+5;x++){
            Fragment fragment = new Fragment(new Position(x,wall.getPosition().getY()-3),new Size(1,1), new Image(),'#');
            buildFragmentImage(fragment);

            wall.addFragment(fragment);
        }
        for(int x=wall.getPosition().getX()+2; x<=wall.getPosition().getX()+6;x++){
            Fragment fragment = new Fragment(new Position(x,wall.getPosition().getY()-2),new Size(1,1), new Image(),'#');
            buildFragmentImage(fragment);

            wall.addFragment(fragment);
        }
        for(int x=wall.getPosition().getX()+1; x<=wall.getPosition().getX()+7;x++){
            Fragment fragment = new Fragment(new Position(x,wall.getPosition().getY()-1),new Size(1,1), new Image(),'#');
            buildFragmentImage(fragment);

            wall.addFragment(fragment);
        }
        for(int x=wall.getPosition().getX(); x<=wall.getPosition().getX()+8;x++){
            Fragment fragment = new Fragment(new Position(x,wall.getPosition().getY()),new Size(1,1), new Image(),'#');
            buildFragmentImage(fragment);

            wall.addFragment(fragment);
        }
        return wall;
    }

    public void buildFragmentImage(Fragment fragment){
        for (int i=0;i<fragment.getSize().getWidth();i++) {
            try {
                fragment.getImage().getPixelMatrix().addPixel(new Pixel(new Position(fragment.getPosition().getX() + i, fragment.getPosition().getY()), fragment.getChar()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        fragment.getImage().setColor("#000000");
        fragment.getImage().setBold(true);

        fragment.getImage().updateSize();
    }

}
