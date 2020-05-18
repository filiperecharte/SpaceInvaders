package com.spaceinvaders.viewtest.lanternaimagesfactoriestests;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.view.lanternaimagesfactories.ShipImageFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShipImageFactoryTest {

    @Test
    public void createTest() {

        TextColor backgroundColor = new TextColor.RGB(50, 100, 150);

        TextImage image = new ShipImageFactory().create(backgroundColor);

        assertEquals(new TextCharacter('/', new TextColor.RGB(255, 255, 51), backgroundColor), image.getCharacterAt(0, 0));
        assertEquals(new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor), image.getCharacterAt(1, 0));
        assertEquals(new TextCharacter('^', new TextColor.RGB(255, 255, 51), backgroundColor), image.getCharacterAt(2, 0));
        assertEquals(new TextCharacter('-', new TextColor.RGB(255, 255, 51), backgroundColor), image.getCharacterAt(3, 0));
        assertEquals(new TextCharacter('\\', new TextColor.RGB(255, 255, 51), backgroundColor), image.getCharacterAt(4, 0));

        assertEquals(new TerminalSize(5, 1), image.getSize());

    }
}
