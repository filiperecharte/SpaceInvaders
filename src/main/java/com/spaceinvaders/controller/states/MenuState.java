package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.states.playstate.PlayState;
import com.spaceinvaders.view.lanternaview.GameView;
import com.spaceinvaders.view.lanternaview.staterenderers.MenuRenderer;

public class MenuState extends GameState{
    public MenuState(GameController gameController) {
        super(gameController);
        gameController.getGameView().setRenderer(new MenuRenderer());
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        switch (input) {
            case SPACE:
                gameController.setGameState(new PlayState(gameController));
                break;
            case INF:
                gameController.setGameState(new InformationState(gameController));
                break;
            case ESC:

            case CLOSE:
                gameController.setGameFinished();
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
