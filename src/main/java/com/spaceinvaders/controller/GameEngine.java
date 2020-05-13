package com.spaceinvaders.controller;

import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.pools.ShotPoolGroup;
import com.spaceinvaders.model.shots.Shot;
import com.spaceinvaders.view.GameView;

import java.io.IOException;

public class GameEngine {
    private boolean isFinished;
    private GameView gameView;
    private Arena arena;
    private ShotPoolGroup shotPoolGroup;
    private ShotsController shotsController;

    private long start;

    public GameEngine(GameView gameView, Arena arena) {
        isFinished = false;
        this.gameView = gameView;
        this.arena = arena;
        this.shotPoolGroup = new ShotPoolGroup();
        this.shotsController = new ShotsController(arena, shotPoolGroup);
        start = System.currentTimeMillis();
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
                (new ShootShipCommand(arena, shotPoolGroup)).execute();
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
        if (arena.getEnemies().get(0).getPosition().getX() < 1|| arena.getEnemies().get(0).getPosition().getX()  + arena.getEnemies().size()*3> 78) {
            arena.changeEnemiesDir();
        }
        shotsController.generateEnemyShot();
        shotsController.processShots();
        arena.updateEnemies();
    }

    public void run() throws IOException {
        long counter=0;
        while (!isFinished) {
            if(counter%65==0)
                gameActions();
            gameView.update();
            executeNextCommand();
            counter++;
        }
    }
}
