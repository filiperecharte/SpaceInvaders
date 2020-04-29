package Model;

public class Ship extends Element{
    private Position position;
    private boolean isAlive;
    private String design;

    public Ship(int x, int y){
        super(x,y);
        design="/-^-\\";
        isAlive=true;
    }

    public String getDesign() {return design;}

}
