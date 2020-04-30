package controller.commands.shipcommands;

import controller.commands.Command;
import controller.NeighboursPosition;
import model.arena.Arena;
import model.geometry.Position;

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
