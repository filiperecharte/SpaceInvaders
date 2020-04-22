package Controller;

import com.googlecode.lanterna.input.KeyStroke;

public class GameEngine {

    public void keyHandler(KeyStroke key) {

        switch (key.getKeyType()) {
            case ArrowLeft:
                // move ship left
                break;

            case ArrowRight:
                // move ship right
                break;

            case Character:

                if (key.getCharacter() == ' ') {
                    // ship shoot
                }
        }
    }
}
