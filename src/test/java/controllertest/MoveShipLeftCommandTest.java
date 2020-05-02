package controllertest;

import controller.commands.shipcommands.MoveShipLeftCommand;
import model.Ship;
import model.arena.Arena;
import model.geometry.Position;
import model.geometry.Size;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MoveShipLeftCommandTest {
    private Arena mockArena;
    @Before
    public void setUp() {
        mockArena = Mockito.mock(Arena.class);
        when(mockArena.getShipPosition()).thenReturn(new Position(10,20));

        mockArena= new Arena(10,15,"FFFFFF",new Ship(new Position(10,20),new Size(4,1)));
    }

    @Test
    public void MoveLeftTest() {

        MoveShipLeftCommand moveShipLeftCommand = new MoveShipLeftCommand(mockArena);
        moveShipLeftCommand.execute();

        assertEquals(9, mockArena.getShipPosition().getX());
        assertEquals(20, mockArena.getShipPosition().getY());
    }

}
