package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.view.lanternaview.GameView;

public class PlayState extends GameState{

    public PlayState(GameController gameController) {
        super(gameController);
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        switch (input) {
            case LEFT:
                (new MoveShipLeftCommand(gameController.getGameArena())).execute();
                break;

            case RIGHT:
                (new MoveShipRightCommand(gameController.getGameArena())).execute();
                break;

            case SPACE:
                (new ShootShipCommand(gameController.getGameArena(), gameController.getGameShotPool())).execute();
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
