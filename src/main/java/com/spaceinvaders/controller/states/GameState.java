package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.view.lanternaview.GameView;

public abstract class GameState {
    protected GameController gameController;

    public GameState(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void handleInput(GameView.keysNames input);
    public abstract void update();
}
