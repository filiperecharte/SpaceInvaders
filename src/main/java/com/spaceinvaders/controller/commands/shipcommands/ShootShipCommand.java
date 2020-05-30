package com.spaceinvaders.controller.commands.shipcommands;

import com.spaceinvaders.controller.commands.Command;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.shots.Shot;

public class ShootShipCommand implements Command {
    private Arena arena;
    private ShotPool shotPool;

    public ShootShipCommand(Arena arena, ShotPool shotPool) {
        this.arena = arena;
        this.shotPool = shotPool;
    }

    @Override
    public void execute() {
        Shot shot = shotPool.extract();
        arena.getShip().processShot(shot);
        arena.addElement(shot);
    }
}
