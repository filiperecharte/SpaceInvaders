package com.spaceinvaders.model.wall;

import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Box {
    private Size size;
    private char c;
    private Image image;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    public Wall(Position position, Size size) {
        super(position, size);
        this.image= new Image();
    }

    public void addFragment(Fragment fragment){
        //adiciona fragmento a lista de fragmentos
        fragments.add(fragment);

        //adiciona pixeis do fragmento a image da wall
        for (int i=0;i<=fragment.getSize().getWidth();i++)
            image.addPixel(new Pixel(new Position(fragment.getPosition().getX()+i,fragment.getPosition().getY()), fragment.getChar()));

        image.setColor("#000000");
        image.setBold(true);
    }

    public void removeFragment(Fragment fragment){
        for(int i=0;i<fragments.size();i++){
            if(fragments.get(i).getPosition()==fragment.getPosition()){
                fragments.remove(i);
                break;
            }
        }
    }

    public Image getImage() {
        return image;
    }

    public List<Fragment> getFragments(){
        return fragments;
    }

}
