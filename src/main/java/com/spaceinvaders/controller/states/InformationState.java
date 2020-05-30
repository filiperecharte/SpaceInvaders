package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.view.lanternaview.GameView;
import com.spaceinvaders.view.lanternaview.InformationRenderer;
import com.spaceinvaders.view.lanternaview.MenuRenderer;

public class InformationState extends GameState{
    public InformationState(GameController gameController) {
        super(gameController);
        gameController.getGameView().setRenderer(new InformationRenderer());
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        switch (input) {
            case ESC:
                gameController.setGameState(new MenuState(gameController));
                break;

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
