package modeltest;

import model.geometry.Position;
import model.image.Image;
import model.image.Pixel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ImageTest {
    private Position mockPosition;
    private Image image;
    @Before
    public void setUp() {
        mockPosition = Mockito.mock(Position.class);
        when(mockPosition.equals(new Position(10,10))).thenReturn(true);

        image = new Image();

        image.addPixel(new Pixel(new Position(5,5),'#'));
        image.addPixel(new Pixel(new Position(6,19),'p'));
        image.addPixel(new Pixel(new Position(3,45),'x'));
        image.addPixel(new Pixel(new Position(23,48),'8'));
        image.addPixel(new Pixel(new Position(34,12),'y'));
    }

    @Test
    public void addPixelTest() {

        assertEquals(5,image.getMatrix().size());
        assertEquals('#',image.getMatrix().get(0).getCharacter());
        assertEquals('p',image.getMatrix().get(1).getCharacter());
        assertEquals('y',image.getMatrix().get(4).getCharacter());
    }

    @Test
    public void findPixelIndexTest() {

        assertEquals(3,image.findPixelIndex(new Position(23,48)));
        assertEquals(0,image.findPixelIndex(new Position(5,5)));
        assertEquals(1,image.findPixelIndex(new Position(6,19)));
        assertEquals(-1,image.findPixelIndex(new Position(10,10)));
    }

    @Test
    public void removePixelTest() {

        image.removePixel(new Position(23,48));

        assertEquals(4,image.getMatrix().size());
        assertEquals(-1,image.findPixelIndex(new Position(23,48))); //nao sei se podemos usar funcoes da classe

    }

    @Test
    public void changePixelCharacterTest() {

        image.changePixelCharacter(new Position(23,48),'U');
        assertEquals('U',image.getMatrix().get(image.findPixelIndex(new Position(23,48))).getCharacter());

    }

    @Test
    public void calculateMaxPixelXTest() {
        assertEquals(34,image.calculateMaxPixelX());

        image.addPixel(new Pixel(new Position(35,12),'y'));
        assertEquals(35,image.calculateMaxPixelX());

    }

    @Test
    public void calculateMaxPixelYTest() {
        assertEquals(48,image.calculateMaxPixelY());

        image.addPixel(new Pixel(new Position(35,90),'y'));
        assertEquals(90,image.calculateMaxPixelY());

    }

    @Test
    public void updateSizeTest() {
        image.updateSize();

        assertEquals(34,image.getSize().getWidth());
        assertEquals(48,image.getSize().getHeight());

    }
}
