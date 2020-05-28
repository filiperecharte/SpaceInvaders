package com.spaceinvaders.controller;

import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.PlayState;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.view.lanternaview.GameOverRenderer;
import com.spaceinvaders.view.lanternaview.GameView;

import java.io.IOException;

public class GameController {
    private GameView gameView;
    private ShotsController shotsController;
    private EnemiesController enemiesController;

    private GameState gameState;
    private boolean isFinished =false;

    public GameController() {
        gameState = new PlayState(this);

        this.gameView = new GameView();
        this.shotsController = new ShotsController();
        this.enemiesController = new EnemiesController();
    }

    public void handleInput() throws IOException{
        GameView.keysNames key = gameView.getInput();

        gameState.handleInput(key);
    }

    public void gameActions(){
        enemiesController.processEnemies();
        shotsController.generateEnemyShot();
        shotsController.processShots();
    }

    public void run() throws IOException {
        long counter=0;
        while (!isFinished) {
            if(counter%100==0)
                gameActions();
            gameView.update();
            handleInput();
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

    public ShotsController getShotsController(){
        return shotsController;
    }

    public EnemiesController getEnemiesController(){
        return enemiesController;
    }

}
