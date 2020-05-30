package com.spaceinvaders.controller.states;

import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.DoNothingCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
import com.spaceinvaders.view.lanternaview.GameView;
import com.spaceinvaders.view.lanternaview.PlayRenderer;

public class PlayState extends GameState {
    private Arena arena;
    private ShotPool shotPool;

    public PlayState(GameController gameController) {
        super(gameController);
        this.arena = new ArenaCreator().createArena(new Position(0, 0), new Size(80, 30), "#808080");
        this.shotPool = new ShotPool();

        gameController.getEnemiesController().setArena(arena);
        gameController.getShotsController().setArena(arena);
        gameController.getShotsController().setShotPool(shotPool);
        gameController.getGameView().setRenderer(new PlayRenderer(arena));
    }

    @Override
    public void handleInput(GameView.keysNames input) {
        switch (input) {
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
                gameController.setGameFinished();
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void update() {
        if (arena.getShip().getHealthyBehavior().isDead()) {
            gameController.setGameState(new GameOverState(gameController));
        }
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public ShotPool getShotPool() {
        return shotPool;
    }

    public void setShotPool(ShotPool shotPool) {
        this.shotPool = shotPool;
    }
}
