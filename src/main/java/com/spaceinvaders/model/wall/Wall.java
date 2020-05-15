package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.IElementVisited;
import com.spaceinvaders.model.IElementsVisitor;
import com.spaceinvaders.model.MovableFrame;
import com.spaceinvaders.model.collisions.ICollideableVisited;
import com.spaceinvaders.model.collisions.ICollideableVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.image.Image;
import com.spaceinvaders.model.image.Pixel;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Box implements IElementVisited {
    private Size size;

    private List<Fragment> fragments = new ArrayList<Fragment>();

    public Wall(Position position, Size size) {
        super(position, size);

    }

    public void addFragment(Fragment fragment){
        //adiciona fragmento a lista de fragmentos
        fragments.add(fragment);

    }

    public void removeFragment(Fragment fragment) throws IllegalArgumentException {
        for (int i=0; i<fragments.size();i++){
            if (fragments.get(i).equals(fragment)) {
                fragments.remove(fragment);
                return;
            }
        }
        throw new IllegalArgumentException("Fragment does not exist on wall");

    }

    public List<Fragment> getFragments(){
        return fragments;
    }

    @Override
    public void accept(IElementsVisitor visitor) {
        visitor.visit(this);
    }

}
