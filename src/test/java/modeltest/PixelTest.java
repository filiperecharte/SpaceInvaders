package modeltest;

import model.geometry.Position;
import model.image.Pixel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PixelTest {

    Position mockPosition;

    @Before
    public void setUp() {
        mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(5);
        when(mockPosition.getY()).thenReturn(10);
    }

    @Test
    public void PixelGetCharacterTest() {
        Pixel pixelA = new Pixel(mockPosition, 'A');
        Pixel pixelB = new Pixel(mockPosition, 'B');

        assertEquals('A', pixelA.getCharacter());
        assertEquals('B', pixelB.getCharacter());
    }

    @Test
    public void PixelSetCharacterTest() {
        Pixel pixel = new Pixel(mockPosition, 'p');

        pixel.setCharacter('q');
        assertEquals('q', pixel.getCharacter());

        pixel.setCharacter('r');
        assertEquals('r', pixel.getCharacter());
    }

}
