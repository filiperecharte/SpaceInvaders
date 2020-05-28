package com.spaceinvaders.controller;

import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.view.lanternaview.GameView;

import java.io.IOException;

public class GameController {
    private boolean isFinished;
    private GameView gameView;
    private Arena arena;
    private ShotPool shotPool;
    private ShotsController shotsController;
    private EnemiesController enemiesController;

    public GameController(GameView gameView, Arena arena) {
        isFinished = false;
        this.gameView = gameView;
        this.arena = arena;
        this.shotPool = new ShotPool();
        this.shotsController = new ShotsController(arena, shotPool);
        this.enemiesController = new EnemiesController(arena);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void executeNextCommand() throws IOException{
        GameView.keysNames key = gameView.getInput();
        switch (key) {
            case LEFT:
                (new MoveShipLeftCommand(arena)).execute();
                break;

            case RIGHT:
                (new MoveShipRightCommand(arena)).execute();
                break;

            case SPACE:
                (new ShootShipCommand(arena, shotPool)).execute();
                break;

            case CLOSE:
                isFinished = true;
                break;
            case NONE:
                (new DoNothingCommand()).execute();
                break;
        }
    }

    public void gameActions(){
        enemiesController.processEnemies();
        shotsController.generateEnemiesShots();
        shotsController.processShots();
    }

    public void run() throws IOException {
        long counter=0;
        while (!isFinished) {
            if(counter%100==0)
                gameActions();
            gameView.update();
            executeNextCommand();
            counter++;
        }
    }
}
