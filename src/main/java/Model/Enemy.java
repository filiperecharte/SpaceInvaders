package Model;

public class Enemy extends Element{
    private Position position;
    private boolean isAlive;

    public Enemy(int x, int y){
        super(x,y);
        isAlive=true;
    }

}