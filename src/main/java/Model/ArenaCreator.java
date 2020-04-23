package Model;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor) {

        Ship ship = new Ship(new Position(30,22));

        return new Arena(width, height, backgroundColor, ship);
    }
}
