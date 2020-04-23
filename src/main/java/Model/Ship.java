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

    public boolean getHeroStatus(){
        return isAlive;
    }

    public void setHeroStatus(boolean status){
        isAlive = status;
    }

    public String getDesign() {return design;}

}
