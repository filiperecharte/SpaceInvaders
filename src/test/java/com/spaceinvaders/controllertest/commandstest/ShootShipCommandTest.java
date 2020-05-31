package com.spaceinvaders.controllertest.commandstest;

import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.Shot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ShootShipCommandTest {
    private Arena arena;

    @Before
    public void setUp() {

        ShotPool shotPool = Mockito.mock(ShotPool.class);
        Mockito.when(shotPool.extract()).thenReturn(new Shot());

        Ship ship =null;
        try {
            ship = new Ship(new Position(10, 10), new Size(3, 1), new HealthyBehavior(3));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        assert  ship != null;

        arena= new Arena(new Position(0, 0), new Size(10, 15),"FFFFFF");
        arena.addElement(ship);
    }

    @Test
    public void getShootPositionTest() {
            ShootShipCommand shootShipCommand = new ShootShipCommand(arena, new ShotPool());
            shootShipCommand.execute();

            assertEquals(1, arena.getShots().size());
            assertEquals(11, arena.getShots().get(0).getPosition().getX());
            assertEquals(9, arena.getShots().get(0).getPosition().getY());

            shootShipCommand.execute();
            assertEquals(2, arena.getShots().size());
    }
}
