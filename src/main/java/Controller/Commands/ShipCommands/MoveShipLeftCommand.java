package controller.commands.shipcommands;

import controller.commands.Command;
import controller.NeighboursPosition;
import model.arena.Arena;
import model.geometry.Position;

public class MoveShipLeftCommand extends Command {
    private Arena arena;

    public MoveShipLeftCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit right
        Position shipPosition = arena.getShipPosition();
        NeighboursPosition neighboursPosition = new NeighboursPosition(shipPosition);
        arena.moveShipTo(neighboursPosition.left());
    }
}
