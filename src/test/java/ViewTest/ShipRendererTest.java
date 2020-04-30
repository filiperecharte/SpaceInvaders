package ViewTest;

import Model.Position;
import Model.Ship;
import View.ShipRenderer;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ShipRendererTest {
    TerminalScreen screen;

    @Before
    public void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
    }

    @Test
    public void Test1() {

        Ship ship = Mockito.mock(Ship.class);
        Mockito.when(ship.getPosition()).thenReturn(new Position(10, 10));

        // Execute
        ShipRenderer renderer = new ShipRenderer(ship);
        renderer.render(screen.newTextGraphics());

        // Verify
        Mockito.verify(screen, Mockito.times(1)).setCharacter(10, 10, new TextCharacter('/'));
    }
}
