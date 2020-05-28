package com.spaceinvaders.controller;

import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.PlayState;
import com.spaceinvaders.view.lanternaview.GameView;

import java.io.IOException;

public class GameController {
    private GameView gameView;
    private ShotsController shotsController;
    private EnemiesController enemiesController;

    private GameState gameState;
    private boolean isFinished = false;

    private long counter;

    public GameController() {
        this.gameView = new GameView();
        this.shotsController = new ShotsController();
        this.enemiesController = new EnemiesController();
        counter = 0;

        gameState = new PlayState(this);
    }

    public void gameUpdate() throws IOException{
        GameView.keysNames key = gameView.getInput();

        gameState.handleInput(key);
        gameState.update();
    }

    public void gameActions(){
        enemiesController.processEnemies();
        shotsController.generateEnemiesShots();
        shotsController.processShots();
    }

    public void run() throws IOException {
        counter=0;
        while (!isFinished) {
            if(counter%100==0) {
                //gameActions();
                enemiesController.processEnemies();
                shotsController.generateEnemiesShots();
                shotsController.processShots();
            }
            gameView.update();
            gameUpdate();
            counter++;
        }
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

    public ShotsController getShotsController() {
        return shotsController;
    }

    public EnemiesController getEnemiesController() {
        return enemiesController;
    }

    public long getCounter() {
        return counter;
    }
}
