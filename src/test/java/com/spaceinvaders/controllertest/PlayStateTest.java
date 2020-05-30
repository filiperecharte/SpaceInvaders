package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.controller.states.playstate.playstatecontrollers.ShotsController;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.behaviors.HealthyBehavior;
import com.spaceinvaders.model.enemy.enemyvariants.StrongEnemy;
import com.spaceinvaders.model.enemy.enemyvariants.SuperiorEnemy;
import com.spaceinvaders.model.enemy.enemyvariants.WiseEnemy;
import com.spaceinvaders.model.enemy.enemyvariants.YoungEnemy;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.model.ship.Ship;
import com.spaceinvaders.model.shots.enemyshotvariants.WeakShot;
import com.spaceinvaders.model.wall.Fragment;
import com.spaceinvaders.model.wall.Wall;
import com.spaceinvaders.view.lanternaview.GameView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class PlayStateTest {
    GameController gameController;
    PlayState playState;

    @Before
    public void setUp() {
        gameController = Mockito.mock(GameController.class);
        when(gameController.isGameFinished()).thenReturn(false);
        when(gameController.getGameView()).thenReturn(new GameView());

        playState = new PlayState(gameController);
    }

    @Test
    public void handleInputTest() {

        assertFalse(gameController.isGameFinished());

        assertEquals(new Position(30, 22), playState.getArena().getShip().getPosition());

        playState.handleInput(GameView.keysNames.LEFT);
        assertEquals(new Position(29, 22), playState.getArena().getShip().getPosition());

        playState.handleInput(GameView.keysNames.LEFT);
        assertEquals(new Position(28, 22), playState.getArena().getShip().getPosition());

        playState.handleInput(GameView.keysNames.RIGHT);
        assertEquals(new Position(29, 22), playState.getArena().getShip().getPosition());

        playState.handleInput(GameView.keysNames.RIGHT);
        assertEquals(new Position(30, 22), playState.getArena().getShip().getPosition());

        assertEquals(0, playState.getArena().getShots().size());
        playState.handleInput(GameView.keysNames.SPACE);
        assertEquals(1, playState.getArena().getShots().size());
        assertEquals(playState.getArena().getShip().getShootPosition(), playState.getArena().getShots().get(0).getPosition());

        playState.handleInput(GameView.keysNames.ESC);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(MenuState.class));

        when(gameController.isGameFinished()).thenReturn(true);
        playState.handleInput(GameView.keysNames.CLOSE);
        assertTrue(gameController.isGameFinished());
    }

    @Test
    public void updateTest(){
        /*Arena arena = Mockito.mock(Arena.class);
        Ship ship = Mockito.mock(Ship.class);
        HealthyBehavior hb = Mockito.mock(HealthyBehavior.class);
        when(arena.getShip()).thenReturn(ship);
        when(ship.getHealthyBehavior()).thenReturn(hb);
        when(hb.isDead()).thenReturn(true);
        Mockito.doNothing().when(gameController).setGameState(Mockito.any(MenuState.class));
        playState.update();

        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(MenuState.class));
    */

    }
}
