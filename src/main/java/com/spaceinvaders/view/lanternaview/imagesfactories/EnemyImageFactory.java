package com.spaceinvaders.view.lanternaview.imagesfactories;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.spaceinvaders.model.enemy.enemyvariants.*;

public class EnemyImageFactory{

    public TextImage makeEnemyImage(Object enemyType, TextColor backgroundColor){
        if (enemyType instanceof StrongEnemy){
            return strongEnemyImage(backgroundColor);
        }
        else if (enemyType instanceof OldEnemy){
            return oldEnemyImage(backgroundColor);
        }
        else if (enemyType instanceof SuperiorEnemy){
            return superiorEnemyImage(backgroundColor);
        }
        else if (enemyType instanceof WiseEnemy){
            return wiseEnemyImage(backgroundColor);
        }
        else if (enemyType instanceof YoungEnemy){
            return youngEnemyImage(backgroundColor);
        }
        return null;
    }

    public TextImage strongEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(3, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('o', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('\\', new TextColor.RGB(0, 0, 128), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage oldEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('_', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('-', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('0', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('-', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('_', new TextColor.RGB(0, 100, 0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage superiorEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('~', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('^', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('~', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('/', new TextColor.RGB(128, 0, 0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage wiseEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(5, 1);

        image.setCharacterAt(0, 0, new TextCharacter('/', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('_', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('^', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(3, 0, new TextCharacter('_', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(4, 0, new TextCharacter('/', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));

        return image;
    }

    public TextImage youngEnemyImage(TextColor backgroundColor) {
        TextImage image = new BasicTextImage(3, 1);

        image.setCharacterAt(0, 0, new TextCharacter('-', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(1, 0, new TextCharacter('o', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));
        image.setCharacterAt(2, 0, new TextCharacter('-', new TextColor.RGB(255,140,0), backgroundColor, SGR.BOLD));

        return image;
    }

}
