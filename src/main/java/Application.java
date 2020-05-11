import com.spaceinvaders.controller.GameEngine;
import com.spaceinvaders.exceptions.IllegalArgumentException;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.view.GameView;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Arena arena = new ArenaCreator().createArena(new Position(0, 0), new Size(100, 100), "#808080");
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
