package com.spaceinvaders.controller.commands.shipcommands;

import com.spaceinvaders.controller.commands.Command;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;

public class ShootShipCommand implements Command {
    private Arena arena;
    private ShotPoolGroup shotPoolGroup;


    public ShootShipCommand(Arena arena, ShotPoolGroup shotPoolGroup) {
        this.arena = arena;
        this.shotPoolGroup = shotPoolGroup;
    }

    @Override
    public void execute() {
        Position shootShipPosition = arena.getShip().getShootPosition();
        Shot shot = shotPoolGroup.getShipShotPool().extract();
        shot.setPosition(shootShipPosition);
        arena.addElement(shot);
    }
}
