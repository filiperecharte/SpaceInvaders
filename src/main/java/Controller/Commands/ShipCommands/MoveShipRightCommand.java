package Controller.Commands.ShipCommands;

import Controller.Commands.Command;
import Model.Position;
import Model.Ship;

public class MoveShipRightCommand extends Command {
    private Arena arena;

    public MoveShipRightCommand(Ship ship) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit left
        Position nextShipPosition = arena.getShipPosition().left(1);
        arena.moveShipTo(nextShipPosition);
    }
}
