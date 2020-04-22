package Controller.Commands.ShipCommands;

import Controller.Commands.Command;
import Model.Arena;

public class QuitCommand extends Command {
    private final Arena arena;

    public QuitCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {
        arena.finish();
    }
}
