package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.view.lanternaview.GameView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class GameOverTest {
    GameController gameController;
    GameOverState gameOverState;

    @Before
    public void setUp() {
        gameController = Mockito.mock(GameController.class);
        when(gameController.isGameFinished()).thenReturn(false);
        when(gameController.getGameView()).thenReturn(new GameView());

        gameOverState = new GameOverState(gameController);
    }

    @Test
    public void handleInputTest() {

        gameOverState.handleInput(GameView.keysNames.SPACE);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(PlayState.class));

        gameOverState.handleInput(GameView.keysNames.ESC);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(MenuState.class));

        when(gameController.isGameFinished()).thenReturn(true);
        gameOverState.handleInput(GameView.keysNames.CLOSE);
        assertTrue(gameController.isGameFinished());
    }

}
