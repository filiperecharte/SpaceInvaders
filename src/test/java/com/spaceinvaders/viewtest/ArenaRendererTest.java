package com.spaceinvaders.viewtest;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.spaceinvaders.model.arena.Arena;
import com.spaceinvaders.view.ArenaRenderer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ArenaRendererTest {
    TerminalScreen screen;

    @Before
    public void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
    }

    @Test
    public void Test1() {

        Arena arena = Mockito.mock(Arena.class);
        Mockito.when(arena.getBackgroundColor()).thenReturn("#92a8d1");
        Mockito.when(arena.getHeight()).thenReturn(100);
        Mockito.when(arena.getWidth()).thenReturn(100);

        // Execute
        ArenaRenderer renderer = new ArenaRenderer(arena);
        renderer.render(screen.newTextGraphics());

        // Verify
        Mockito.verify(screen, Mockito.times(1)).newTextGraphics().fillRectangle(new TerminalPosition(0, 0), new TerminalSize(100, 100), ' ');
    }
}
