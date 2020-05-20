package com.spaceinvaders.controllertest.commandstest;

import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.ship.Ship;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShootShipCommandTest {
    private Arena arena;
    @Before
    public void setUp() {

        Ship ship =null;
        try {
            ship = new Ship(new Position(10, 10), new Size(3, 1));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        assert  ship != null;

        arena= new Arena(new Position(0, 0), new Size(10, 15),"FFFFFF");
        arena.addElement(ship);
    }

    @Test
    public void getShootPositionTest() {
            ShootShipCommand shootShipCommand = new ShootShipCommand(arena, new ShotPoolGroup());
            shootShipCommand.execute();

            assertEquals(1, arena.getShots().size());
            assertEquals(11, arena.getShots().get(0).getPosition().getX());
            assertEquals(10, arena.getShots().get(0).getPosition().getY());

            shootShipCommand.execute();
            assertEquals(2, arena.getShots().size());
    }
}
