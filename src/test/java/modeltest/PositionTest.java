package modeltest;

import model.geometry.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void PositionTestGets() {
        Position position = new Position(2,7);

        assertEquals(2, position.getX());
        assertEquals(7,position.getY());

    }

    @Test
    public void PositionTestSets() {
        Position position = new Position(3,4);
        position.setY(2);
        position.setX(7);

        assertEquals(7, position.getX());
        assertEquals(2,position.getY());

    }

}
