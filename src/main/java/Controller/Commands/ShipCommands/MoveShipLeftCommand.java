package Controller.Commands.ShipCommands;

import Controller.Commands.Command;
import Model.Position;

public class MoveShipLeftCommand extends Command {
    private Arena arena;

    public MoveShipLeftCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit right
        Position nextShipPosition = arena.getShipPosition().left(1);
        arena.moveShipTo(nextShipPosition);
    }
}
