package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.InformationState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.view.lanternaview.GameView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class MenuStateTest {
    GameController gameController;
    MenuState menuState;

    @Before
    public void setUp() {
        gameController = Mockito.mock(GameController.class);
        when(gameController.isGameFinished()).thenReturn(false);
        when(gameController.getGameView()).thenReturn(new GameView());

        menuState = new MenuState(gameController);
    }

    @Test
    public void handleInputTest() {
        menuState.handleInput(GameView.keysNames.SPACE);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(PlayState.class));

        menuState.handleInput(GameView.keysNames.INF);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(InformationState.class));

        when(gameController.isGameFinished()).thenReturn(true);
        menuState.handleInput(GameView.keysNames.CLOSE);
        assertTrue(gameController.isGameFinished());

        when(gameController.isGameFinished()).thenReturn(true);
        menuState.handleInput(GameView.keysNames.ESC);
        assertTrue(gameController.isGameFinished());
    }
}
