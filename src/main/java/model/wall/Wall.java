package model.wall;

import model.Box;
import model.Fragment;
import model.geometry.Position;
import model.geometry.Size;
import model.image.Image;
import model.image.Pixel;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Box {
    private Size size;
    private char c;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    public Wall(Position position, Size size) {
        super(position, size);
    }

    public void addFragment(Fragment fragment){
        fragments.add(fragment);
    }

    public void removeFragment(Fragment fragment){
        for(int i=0;i<fragments.size();i++){
            if(fragments.get(i).getPosition()==fragment.getPosition()){
                fragments.remove(i);
                break;
            }
        }
    }

    public List<Fragment> getFragments(){
        return fragments;
    }

}
