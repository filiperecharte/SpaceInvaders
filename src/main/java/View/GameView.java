package View;

import Controller.Commands.Command;
import Controller.Commands.ShipCommands.MoveShipLeftCommand;
import Controller.Commands.ShipCommands.MoveShipRightCommand;
import Controller.GameEngine;
import Model.Arena;
import Model.ArenaCreator;
import View.GameRenderer;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.ArrowLeft;

public class GameView {
    private TextGraphics graphics;
    private Screen screen;
    private Arena arena;
    private GameRenderer gameRenderer;
    private GameEngine gameEngine;
    public enum keysNames {NONE, LEFT, RIGHT, SPACE, CLOSE};

    public GameView(Arena arena) {
        this.arena = arena;
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            this.graphics = screen.newTextGraphics();

            this.gameRenderer = new GameRenderer(arena,arena.getShip());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() throws IOException { //this should be on GameRenderer? Do we need a game renderer?
        screen.clear();
        gameRenderer.render(graphics); //render all objects
        screen.refresh();
    }

    public keysNames getInput() throws IOException {

        KeyStroke key = screen.readInput();;

        switch (key.getKeyType()) {
            case ArrowLeft:
                return keysNames.LEFT;

            case ArrowRight:
                return keysNames.RIGHT;

            case Character:

                if (key.getCharacter() == ' ') {
                    return keysNames.SPACE;
                }
            case EOF:
                return keysNames.CLOSE;

            default:
                return keysNames.NONE;
        }
    }

    public void end() throws IOException {
        screen.close();
    }

    /*public void run() throws IOException{
        while (!gameEngine.isFinished()) {
            update();

            KeyStroke key = screen.readInput();
            gameEngine.executeNextCommand(key);
        }
        screen.close();
    }*/
}