import Controller.GameEngine;
import Model.Arena.Arena;
import Model.Arena.ArenaCreator;
import View.GameView;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Arena arena = new ArenaCreator().createArena(100, 100, "#92a8d1");
        GameView gameView = new GameView(arena);
        GameEngine gameEngine = new GameEngine(gameView, arena);
        try {
            gameEngine.run();
            gameView.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
