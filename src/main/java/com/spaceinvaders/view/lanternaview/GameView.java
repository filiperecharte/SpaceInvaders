package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

import java.io.IOException;

public class GameView {
    private TextGraphics graphics;
    private Screen screen;
    private Renderer renderer;
    public enum keysNames {NONE, LEFT, RIGHT, SPACE, CLOSE, INF, ESC};

    public GameView() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();

            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);   // we don't need a cursor
            this.screen.startScreen();             // screens must be started
            this.screen.doResizeIfNecessary();     // resize screen if necessary

            this.graphics = screen.newTextGraphics();
            graphics.enableModifiers(SGR.BOLD);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() throws IOException {
        //screen.clear();
        renderer.render(graphics); //render all objects
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
                else if (key.getCharacter() == 'I' || key.getCharacter() == 'i'){
                    return keysNames.INF;
                }
                return keysNames.NONE;
            case Escape:
                return keysNames.ESC;

            case EOF:
                return keysNames.CLOSE;

            default:
                return keysNames.NONE;
        }
    }

    public void end() throws IOException {
        screen.close();
    }

    public void setRenderer(Renderer renderer){
        this.renderer=renderer;
    }
}
