package com.spaceinvaders.controllertest;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.InformationState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.view.lanternaview.GameView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class InformationStateTest {
    GameController gameController;
    InformationState informationState;

    @Before
    public void setUp() {
        gameController = Mockito.mock(GameController.class);
        when(gameController.isGameFinished()).thenReturn(false);
        when(gameController.getGameView()).thenReturn(new GameView());

        informationState = new InformationState(gameController);
    }

    @Test
    public void handleInputTest() {

        when(gameController.isGameFinished()).thenReturn(true);
        informationState.handleInput(GameView.keysNames.CLOSE);
        assertTrue(gameController.isGameFinished());

        when(gameController.isGameFinished()).thenReturn(true);
        informationState.handleInput(GameView.keysNames.ESC);
        Mockito.verify(gameController, times(1)).setGameState(Mockito.any(MenuState.class));
    }
}
