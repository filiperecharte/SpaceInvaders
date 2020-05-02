package controllertest;

import controller.commands.shipcommands.MoveShipLeftCommand;
import javafx.geometry.Pos;
import model.Ship;
import model.arena.Arena;
import model.geometry.Position;
import model.geometry.Size;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoveShipLeftCommandTest {
    private Arena mockArena;
    @Before
    public void setUp() {
        mockArena = Mockito.mock(Arena.class);
        when(mockArena.getShipPosition()).thenReturn(new Position(10,20));

    }

    @Test
    public void MoveLeftTest() {
        ArgumentCaptor<Position> argument = ArgumentCaptor.forClass(Position.class);

        MoveShipLeftCommand moveShipLeftCommand = new MoveShipLeftCommand(mockArena);
        moveShipLeftCommand.execute();

        verify(mockArena).moveShipTo(argument.capture());

        assertEquals(9, argument.getValue().getX());
        assertEquals(20, argument.getValue().getY());
    }

}
