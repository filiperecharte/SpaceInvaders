import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.view.lanternaview.GameView;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Arena arena = new ArenaCreator().createArena(new Position(0, 0), new Size(80, 30), "#808080");
        GameView gameView = new GameView(arena);
        GameController gameController = new GameController(gameView, arena);
        try {
            gameController.run();
            gameView.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
