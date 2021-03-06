package com.spaceinvaders.controller.commands.shipcommands;

import com.spaceinvaders.controller.commands.Command;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Translation;
import com.spaceinvaders.model.geometry.Vector;

public class MoveShipLeftCommand implements Command {
    private Arena arena;

    public MoveShipLeftCommand(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void execute() {
        // move ship 1 unit left
        Position shipPosition = arena.getShipPosition();
        Translation translation = new Translation(shipPosition, new Vector(-1, 0));
        arena.moveShipTo(translation.apply());
    }
}
