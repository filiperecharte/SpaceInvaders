package Controller.Commands.ShipCommands;

import Controller.Commands.Command;
import Controller.NeighboursPosition;
import Model.Arena.Arena;
import Model.Position;

public class MoveShipRightCommand extends Command {
    private Arena arena;

    public MoveShipRightCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit left
        Position shipPosition = arena.getShipPosition();
        NeighboursPosition neighboursPosition = new NeighboursPosition(shipPosition);
        arena.moveShipTo(neighboursPosition.right());
    }
}
