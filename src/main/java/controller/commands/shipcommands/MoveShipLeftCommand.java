package controller.commands.shipcommands;

import controller.commands.Command;
import model.arena.Arena;
import model.geometry.Position;
import model.geometry.Translaction;
import model.geometry.Vector;

public class MoveShipLeftCommand extends Command {
    private Arena arena;

    public MoveShipLeftCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {

        // move ship 1 unit left
        Position shipPosition = arena.getShipPosition();
        Translaction translaction = new Translaction(shipPosition, new Vector(-1, 0));
        arena.moveShipTo(translaction.apply());
    }
}
