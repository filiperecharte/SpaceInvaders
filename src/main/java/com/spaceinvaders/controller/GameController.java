package com.spaceinvaders.controller;

import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.PlayState;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.view.lanternaview.GameView;

import java.io.IOException;

public class GameController {
    private GameView gameView;
    private Arena arena;
    private ShotPool shotPool;
    private ShotsController shotsController;
    private EnemiesController enemiesController;

    private GameState gameState;
    private boolean isFinished =false;

    public GameController(GameView gameView, Arena arena) {
        gameState = new PlayState(this);

        this.gameView = gameView;
        this.arena = arena;
        this.shotPool = new ShotPool();
        this.shotsController = new ShotsController(arena, shotPool);
        this.enemiesController = new EnemiesController(arena);
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

    public Arena getGameArena(){
        return arena;
    }

    public ShotPool getGameShotPool(){
        return shotPool;
    }

    public void setGameFinished(){
        this.isFinished=true;
    }
}
