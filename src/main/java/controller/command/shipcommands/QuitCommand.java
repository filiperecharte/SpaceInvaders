package controller.commands.shipcommands;

import controller.commands.Command;
import model.arena.Arena;

public class QuitCommand extends Command {
    private final Arena arena;

    public QuitCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {
        //arena.finish();
    }
}
