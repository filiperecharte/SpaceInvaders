package Model;

public class Arena {
    private int width;
    private int height;
    private Ship ship;

    public Arena(int width, int height){
        this.height=height;
        this.width=width;
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

        //Wall wall = (Wall) getCollidingElement(position, walls);
        //return wall == null;
        return true;
    }

    public void moveShipTo(Position position) {
        if (canMove(position)) ship.setPosition(position);
        //checkCollisions(ship.getPosition());

        //this.notifyObservers();
    }

    public Position getShipPosition() {
        return ship.getPosition();
    }

    public void moveShip(String move) {
        switch (move) {
            case "up":
                if (ship.getPosition().getY() > 1)
                    ship.moveUp();
                break;
            case "down":
                if (ship.getPosition().getY() < this.height - 2)
                    ship.moveDown();
                break;
            case "left":
                if (ship.getPosition().getX() > 1)
                    ship.moveLeft();
                break;
            case "right":
                if (ship.getPosition().getX() < this.width - 2)
                    ship.moveRight();
                break;
            default:
                break;
        }
    }

}
