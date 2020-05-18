package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.spaceinvaders.model.arena.Arena;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.spaceinvaders.view.lanternaview.GameRenderer;

import java.io.IOException;

public class GameView {
    private TextGraphics graphics;
    private Screen screen;
    private Arena arena;
    private GameRenderer gameRenderer;
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
            graphics.enableModifiers(SGR.BOLD);

            this.gameRenderer = new GameRenderer(arena);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() throws IOException {
        //screen.clear();
        gameRenderer.render(graphics); //render all objects
        screen.refresh();
    }

    public keysNames getInput() throws IOException {

        KeyStroke key = screen.pollInput();
        if (key==null){
            return keysNames.NONE;
        }

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
}
