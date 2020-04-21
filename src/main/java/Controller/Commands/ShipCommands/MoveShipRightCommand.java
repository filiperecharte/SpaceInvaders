package Controller.Commands.ShipCommands;

import Controller.Commands.Command;
import Model.Position;

public class MoveShipRightCommand extends Command {
    private Arena arena;

    public MoveShipRightCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit left
        Position nextShipPosition = arena.getShipPosition().right(1);
        arena.moveShipTo(nextShipPosition);
    }
}
