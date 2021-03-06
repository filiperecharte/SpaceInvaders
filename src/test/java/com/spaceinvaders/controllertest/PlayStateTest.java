package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.model.geometry.Position;
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
}
