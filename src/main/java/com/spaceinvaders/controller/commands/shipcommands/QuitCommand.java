package com.spaceinvaders.controller.commands.shipcommands;

import com.spaceinvaders.controller.commands.Command;
import com.spaceinvaders.model.arena.Arena;

public class QuitCommand extends Command {
    private final Arena arena;

    public QuitCommand(Arena arena) {
        this.arena = arena;
    }

    public void execute() {
        //arena.finish();
    }
}
