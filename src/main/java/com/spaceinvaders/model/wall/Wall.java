package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Box implements IElementVisited {
    private Size size;
    private char c;
    private Image image;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    public Wall(Position position, Size size, Image image) {
        super(position, size);
        this.image= image;
    }

    public void addFragment(Fragment fragment){
        //adiciona fragmento a lista de fragmentos
        fragments.add(fragment);

        //adiciona pixeis do fragmento a image da wall
        for (int i=0;i<fragment.getSize().getWidth();i++) {
            try {
                image.getPixelMatrix().addPixel(new Pixel(new Position(fragment.getPosition().getX() + i, fragment.getPosition().getY()), fragment.getChar()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        image.setColor("#000000");
        image.setBold(true);

        image.updateSize();
    }

    public void removeFragment(Fragment fragment){
        for(int i=0;i<fragments.size();i++){
            if(fragments.get(i).getPosition().equals(fragment.getPosition())){
                fragments.remove(i);
                break;
            }
        }
        for (int i=0;i<fragment.getSize().getWidth();i++) {
            if(fragment.getPosition().equals(fragment.getPosition())) {
                try {
                    image.getPixelMatrix().removePixel(new Position(fragment.getPosition().getX() + i, fragment.getPosition().getY()));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        image.updateSize();
    }

    public Image getImage() {
        return image;
    }

    public List<Fragment> getFragments(){
        return fragments;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }
}
