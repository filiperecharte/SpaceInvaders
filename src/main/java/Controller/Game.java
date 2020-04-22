package Controller;

import Controller.Commands.Command;
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
            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            this.graphics = screen.newTextGraphics();

            /*this.arena = new Arena(100,100);
            this.arenaRenderer= new ArenaRenderer(arena);

            this.gameEngine = new GameEngine(arena);*/
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
            Command command = gameEngine.getNextCommand(key);
            command.execute();

            if (key.getKeyType() == KeyType.EOF) {
                screen.close();
                break;
            }
        }
    }
}
