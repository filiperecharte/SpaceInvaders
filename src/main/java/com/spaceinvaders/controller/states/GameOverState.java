package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.view.lanternaview.GameView;

public class GameOverState extends GameState{

    public GameOverState(GameController gameController) {
        super(gameController);
    }

    @Override
    public void handleInput(GameView.keysNames input) {

    }
}
