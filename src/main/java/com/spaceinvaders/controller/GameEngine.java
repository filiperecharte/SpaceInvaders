package com.spaceinvaders.controller;

import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.view.GameView;

import java.io.IOException;

public class GameEngine {
    private boolean isFinished;
    private GameView gameView;
    private Arena arena;

    public GameEngine(GameView gameView, Arena arena) {
        isFinished = false;
        this.gameView = gameView;
        this.arena = arena;
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
                // ship shoot
                break;

            case CLOSE:
                isFinished = true;
                break;
        }
    }

    public void run() throws IOException {
        while (!isFinished) {
            gameView.update();

            executeNextCommand();
        }
    }
}
