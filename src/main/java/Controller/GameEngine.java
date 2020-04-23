package Controller;

import Controller.Commands.Command;
import Controller.Commands.ShipCommands.DoNothingCommand;
import Controller.Commands.ShipCommands.MoveShipLeftCommand;
import Controller.Commands.ShipCommands.MoveShipRightCommand;
import Controller.Commands.ShipCommands.QuitCommand;
import Model.Arena;
import com.googlecode.lanterna.input.KeyStroke;

public class GameEngine {
    private Arena arena;
    private boolean isFinished;

    public GameEngine(Arena arena) {
        isFinished = false;
        this.arena=arena;
    }

    public boolean isFinished() {
        return isFinished;
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
            case EOF:
                return new QuitCommand(arena);
        }
        return new DoNothingCommand();
    }

    public void executeNextCommand(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowLeft:
                (new MoveShipLeftCommand(arena)).execute();
                break;

            case ArrowRight:
                (new MoveShipRightCommand(arena)).execute();
                break;

            case Character:

                if (key.getCharacter() == ' ') {
                    // ship shoot
                }
            case EOF:
                isFinished = true;
                break;
        }
    }
}
