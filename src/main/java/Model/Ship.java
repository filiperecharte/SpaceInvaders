package Model;

public class Ship {
    private Position position;
    private boolean isAlive;
    private String design;

    public Ship(Position position){
        design="/-^-\\";
        this.position=position;
        isAlive=true;
    }

    public Position getPosition(){ return position; }

    public void setPosition(Position position){
        this.position=position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft(){
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
