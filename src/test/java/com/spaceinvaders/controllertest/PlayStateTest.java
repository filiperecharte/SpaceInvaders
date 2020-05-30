package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.PlayState;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.view.lanternaview.GameView;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayStateTest {

    @Test
    public void handleInputTest() {
        GameController gameController = new GameController();
        assertFalse(gameController.isGameFinished());

        PlayState playState = new PlayState(gameController);
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

        playState.handleInput(GameView.keysNames.CLOSE);
        assertTrue(gameController.isGameFinished());
    }
}
