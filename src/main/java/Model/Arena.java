package Model;

public class Arena {
    private int width;
    private int height;
    private Ship ship;
    private boolean isFinished;

    public Arena(int width, int height){
        this.height=height;
        this.width=width;
        this.ship= new Ship(new Position(30,22));
        isFinished=false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private boolean canMove(Position position) {
        if (position.getX() < 0 || position.getX() >= width) return false;
        if (position.getY() < 0 || position.getY() >= height) return false;

        return true;
    }

    public void moveShipTo(Position position) {
        ship.setPosition(position);

    }

    public Ship getShip(){
        return this.ship;
    }

    public boolean isFinished(){
        return isFinished;
    }

    public void finish() {
        this.isFinished = true;
    }

    public Position getShipPosition() {
        return ship.getPosition();
    }

}
