package Model.Arena;

import Model.Arena.Arena;
import Model.Position;
import Model.Ship;
import Model.Size;

public class ArenaCreator {

    public Arena createArena(int width, int height, String backgroundColor) {

        Ship ship = new Ship(new Position(30, 22), new Size(5, 1));

        return new Arena(width, height, backgroundColor, ship);
    }
}
