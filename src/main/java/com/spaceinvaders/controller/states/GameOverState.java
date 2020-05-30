package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.view.lanternaview.staterenderers.GameOverRenderer;
import com.spaceinvaders.view.lanternaview.GameView;

public class GameOverState extends GameState{

    public GameOverState(GameController gameController) {
        super(gameController);
        gameController.getGameView().setRenderer(new GameOverRenderer());
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        switch (input) {
            case SPACE:
                gameController.setGameState(new PlayState(gameController));
                break;

            case CLOSE:
                gameController.setGameFinished();
                break;
            case ESC:
                gameController.setGameState(new MenuState(gameController));
                break;
            case NONE:
                (new DoNothingCommand()).execute();
                break;
        }
    }

    @Override
    public void update() {
    }
}
