package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.view.lanternaview.GameOverRenderer;
import com.spaceinvaders.view.lanternaview.GameView;

public class GameOverState extends GameState{

    public GameOverState(GameController gameController) {
        super(gameController);
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        gameController.getGameView().setRenderer(new GameOverRenderer());
        switch (input) {
            case SPACE:
                gameController.setGameState(new PlayState(gameController));
                break;

            case CLOSE:
                gameController.setGameFinished();
                break;
            case NONE:
                (new DoNothingCommand()).execute();
                break;
        }
    }
}
