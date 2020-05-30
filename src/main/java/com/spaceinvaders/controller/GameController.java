package com.spaceinvaders.controller;

import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.view.lanternaview.GameView;

import java.io.IOException;

public class GameController {
    private GameView gameView;

    private GameState gameState;
    private boolean isFinished = false;

    public GameController() {
        this.gameView = new GameView();
        gameState = new MenuState(this);

    }

    public void gameUpdate() throws IOException{
        GameView.keysNames key = gameView.getInput();

        gameState.handleInput(key);
        gameState.update();
    }

    public void run() throws IOException {
        while (!isFinished) {
            gameView.update();
            gameUpdate();
        }
        gameView.end();
    }

    public boolean isGameFinished() {
        return this.isFinished;
    }

    public void setGameFinished(){
        this.isFinished=true;
    }

    public void setGameState(GameState gameState) {
        this.gameState=gameState;
    }

    public GameView getGameView() {
        return gameView;
    }

}
