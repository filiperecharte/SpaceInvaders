package Controller;

import Model.Arena;
import View.ArenaRenderer;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {
    private TextGraphics graphics;
    private Screen screen;
    private Arena arena;
    private ArenaRenderer arenaRenderer;
    private GameEngine gameEngine;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            this.graphics = screen.newTextGraphics();

            arena = new Arena(10,10);
            arenaRenderer= new ArenaRenderer(arena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() throws IOException { //this should be on GameRenderer? Do we need a game renderer?
        screen.clear();
        arenaRenderer.render(graphics);
        screen.refresh();
    }

    public void run() throws IOException{
        while (true) {
            update();

            KeyStroke key = screen.readInput();
            gameEngine.keyHandler(key);

            if (key.getKeyType() == KeyType.EOF) {
                screen.close();
                break;
            }
        }
    }
}
