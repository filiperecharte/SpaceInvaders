package com.spaceinvaders.controller.states.playState;

import com.spaceinvaders.controller.states.GameOverState;
import com.spaceinvaders.controller.states.GameState;
import com.spaceinvaders.controller.states.MenuState;
import com.spaceinvaders.controller.states.playState.EnemiesController;
import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.controller.states.playState.ShotsController;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipLeftCommand;
import com.spaceinvaders.controller.commands.shipcommands.MoveShipRightCommand;
import com.spaceinvaders.controller.commands.shipcommands.ShootShipCommand;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.model.pools.ShotPool;
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
        this.shotsController = new ShotsController();
        this.enemiesController = new EnemiesController();

        enemiesController.setArena(arena);
        shotsController.setArena(arena);
        shotsController.setShotPool(shotPool);
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

}
