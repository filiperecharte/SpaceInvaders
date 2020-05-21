package com.spaceinvaders.model.wall;

import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.Box;
import com.spaceinvaders.model.BoxDilator;
import com.spaceinvaders.model.element.IElementVisited;
import com.spaceinvaders.model.element.IElementsVisitor;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Box implements IElementVisited {
    private List<Fragment> fragments = new ArrayList<>();

    public Wall(Position position) {
        super(position, new Size(0, 0));
    }

    public void addFragment(Fragment fragment) throws IllegalArgumentException {
        for (Fragment frag : fragments) {
            if (frag.equals(fragment))
                throw new IllegalArgumentException("Fragment already exists");
        }
        fragments.add(fragment);
        this.setSize(new BoxDilator().dilate(fragments));
    }

    public void removeFragment(Fragment fragment) throws IllegalArgumentException {
        for (int i=0; i<fragments.size();i++){
            if (fragments.get(i).equals(fragment)) {
                fragments.remove(fragment);
                this.setSize(new BoxDilator().dilate(fragments));
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
