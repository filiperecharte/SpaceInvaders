package Controller;

import Controller.Commands.Command;
import Controller.Commands.ShipCommands.MoveShipLeftCommand;
import Controller.Commands.ShipCommands.MoveShipRightCommand;
import Model.Arena;
import com.googlecode.lanterna.input.KeyStroke;

public class GameEngine {
    private Arena arena;

    public GameEngine(Arena arena) {
        this.arena=arena;
    }

    public Command getNextCommand(KeyStroke key) {

        switch (key.getKeyType()) {
            case ArrowLeft:
                return new MoveShipLeftCommand(arena);

            case ArrowRight:
                return new MoveShipRightCommand(arena);

            case Character:

                if (key.getCharacter() == ' ') {
                    // ship shoot
                }
        }
        return null;
    }
}
