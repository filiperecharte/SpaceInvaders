package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class InformationRenderer implements Renderer {
    @Override
    public void render(TextGraphics graphics) {
        graphics.fill(' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(7,1,"  _____        __                           _   _             ", SGR.BOLD);
        graphics.putString(7,2," |_   _|      / _|                         | | (_)            ", SGR.BOLD);
        graphics.putString(7,3,"   | |  _ __ | |_ ___  _ __ _ __ ___   __ _| |_ _  ___  _ __  ", SGR.BOLD);
        graphics.putString(7,4,"   | | | '_ \\|  _/ _ \\| '__| '_ ` _ \\ / _` | __| |/ _ \\| '_ \\ ", SGR.BOLD);
        graphics.putString(7,5,"  _| |_| | | | || (_) | |  | | | | | | (_| | |_| | (_) | | | |", SGR.BOLD);
        graphics.putString(7,6," |_____|_| |_|_| \\___/|_|  |_| |_| |_|\\__,_|\\__|_|\\___/|_| |_|", SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(4,8,"       __        __    ", SGR.BOLD);
        graphics.putString(4,9,"  ___ / /  ___  / /____", SGR.BOLD);
        graphics.putString(4,10," (_-</ _ \\/ _ \\/ __(_-<", SGR.BOLD);
        graphics.putString(4,11,"/___/_//_/\\___/\\__/___/", SGR.BOLD);

        graphics.putString(6,13,"WEAK",SGR.BOLD);
        graphics.putString(21,13,".",SGR.BOLD);

        graphics.putString(6,15,"LEGENDARY",SGR.BOLD);
        graphics.putString(21,15,".",SGR.BOLD);

        graphics.putString(6,17,"IMMATURE",SGR.BOLD);
        graphics.putString(21,17,"*",SGR.BOLD);

        graphics.putString(6,19,"SLICK",SGR.BOLD);
        graphics.putString(21,19,"0",SGR.BOLD);

        graphics.putString(6,21,"POWERFUL",SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#8B0000"));
        graphics.putString(21,21,"o",SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(45,8,"                     _       ", SGR.BOLD);
        graphics.putString(45,9," ___ ___  ___ __ _  (_)__ ___", SGR.BOLD);
        graphics.putString(45,10,"/ -_) _ \\/ -_)  ' \\/ / -_|_-<", SGR.BOLD);
        graphics.putString(45,11,"\\__/_//_/\\__/_/_/_/_/\\__/___/", SGR.BOLD);

        graphics.putString(47,13,"WEAK",SGR.BOLD);
        graphics.putString(21,13,".",SGR.BOLD);

        graphics.putString(6,15,"LEGENDARY",SGR.BOLD);
        graphics.putString(21,15,".",SGR.BOLD);

        graphics.putString(6,17,"IMMATURE",SGR.BOLD);
        graphics.putString(21,17,"*",SGR.BOLD);

        graphics.putString(6,19,"SLICK",SGR.BOLD);
        graphics.putString(21,19,"0",SGR.BOLD);

        graphics.putString(6,21,"POWERFUL",SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#8B0000"));
        graphics.putString(21,21,"o",SGR.BOLD);

    }
}
