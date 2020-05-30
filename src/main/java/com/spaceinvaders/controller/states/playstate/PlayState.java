package com.spaceinvaders.controller.states.playstate;

import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.controller.states.playstate.playstatecontrollers.EnemiesController;
import com.spaceinvaders.controller.states.playstate.playstatecontrollers.ShotsController;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.view.lanternaview.GameView;
import com.spaceinvaders.view.lanternaview.staterenderers.PlayRenderer;

public class PlayState extends GameState {
    private Arena arena;
    private ShotPool shotPool;
    private ShotsController shotsController;
    private EnemiesController enemiesController;

    private long counter = 0;

    public PlayState(GameController gameController) {
        super(gameController);
        this.arena = new ArenaCreator().createArena(new Position(0, 0), new Size(80, 30), "#808080");
        this.shotPool = new ShotPool();
        this.shotsController = new ShotsController(arena,shotPool);
        this.enemiesController = new EnemiesController(arena);

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
            case ESC:
                gameController.setGameState(new MenuState(gameController));
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

        if(counter%130==0) {
            enemiesController.processEnemies();
            shotsController.generateEnemiesShots();
            shotsController.processShots();
        }
        counter++;
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
