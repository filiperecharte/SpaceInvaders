package Model;

public class Ship {
    private Position position;
    private boolean isAlive;
    private String design;

    public Ship(int x, int y){
        design="/-^-\\";
        this.position.setX(x);
        this.position.setY(y);
        isAlive=true;
    }

    public Position getPosition(){ return position; }

    public void setPosition(Position position){
        this.position=position;
    }

    public Position MoveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position MoveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position MoveRight(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position MoveLeft(){
        return new Position(position.getX()-1, position.getY());
    }

    public boolean getHeroStatus(){
        return isAlive;
    }

    public void setHeroStatus(boolean status){
        isAlive = status;
    }

    public String getDesign() {return design;}

}
