package Model;

public class Enemie {
    private Position position;
    private boolean isAlive;

    public Enemie(int x, int y){
        this.position.setX(x);
        this.position.setY(y);
        isAlive=true;
    }

    public Position getPosition(){ return position; }

    public void setPosition(Position position){
        this.position=position;
    }

}
