package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.view.lanternaview.GameView;

public abstract class GameState {
    public GameState(GameController gameController) {
        this.gameController = gameController;
    }

    protected GameController gameController;

    public abstract void handleInput(GameView.keysNames input);
}
