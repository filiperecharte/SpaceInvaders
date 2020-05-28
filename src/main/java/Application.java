import com.spaceinvaders.controller.GameController;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.model.arena.ArenaCreator;
import com.spaceinvaders.model.geometry.Position;
import com.spaceinvaders.model.geometry.Size;
import com.spaceinvaders.view.lanternaview.GameView;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
