package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class MenuRenderer implements Renderer {
    @Override
    public void render(TextGraphics graphics) {
        graphics.fill(' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(3,1,"   _____                          ____                     __              ", SGR.BOLD);
        graphics.putString(3,2,"  / ___/____  ____ _________     /  _/___ _   ______ _____/ /__  __________", SGR.BOLD);
        graphics.putString(3,3,"  \\__ \\/ __ \\/ __ `/ ___/ _ \\    / // __ \\ | / / __ `/ __  / _ \\/ ___/ ___/", SGR.BOLD);
        graphics.putString(3,4," ___/ / /_/ / /_/ / /__/  __/  _/ // / / / |/ / /_/ / /_/ /  __/ /  (__  ) ", SGR.BOLD);
        graphics.putString(3,5,"/____/ .___/\\__,_/\\___/\\___/  /___/_/ /_/|___/\\__,_/\\__,_/\\___/_/  /____/  ", SGR.BOLD);
        graphics.putString(3,6,"    /_/                                                                    ", SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
        graphics.putString(14,8,"                         _              _           ", SGR.BOLD);
        graphics.putString(14,9,"  ____ __  __ _ __ ___  | |_ ___   _ __| |__ _ _  _ ", SGR.BOLD);
        graphics.putString(14,10," (_-< '_ \\/ _` / _/ -_) |  _/ _ \\ | '_ \\ / _` | || |", SGR.BOLD);
        graphics.putString(14,11," /__/ .__/\\__,_\\__\\___|  \\__\\___/ | .__/_\\__,_|\\_, |", SGR.BOLD);
        graphics.putString(14,12,"    |_|                           |_|          |__/ ", SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#00008B"));
        graphics.putString(9,14,"  _    __           _       __                    _   _          ", SGR.BOLD);
        graphics.putString(9,15," (_)  / _|___ _ _  (_)_ _  / _|___ _ _ _ __  __ _| |_(_)___ _ _  ", SGR.BOLD);
        graphics.putString(9,16," | | |  _/ _ \\ '_| | | ' \\|  _/ _ \\ '_| '  \\/ _` |  _| / _ \\ ' \\ ", SGR.BOLD);
        graphics.putString(9,17," |_| |_| \\___/_|   |_|_||_|_| \\___/_| |_|_|_\\__,_|\\__|_\\___/_||_|", SGR.BOLD);

        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.putString(18,19,"               _         _                          ", SGR.BOLD);
        graphics.putString(18,20,"  ___ ___ __  | |_ ___  | |___ __ ___ _____         ", SGR.BOLD);
        graphics.putString(18,21," / -_|_-</ _| |  _/ _ \\ | / -_) _` \\ V / -_)        ", SGR.BOLD);
        graphics.putString(18,22," \\___/__/\\__|  \\__\\___/ |_\\___\\__,_|\\_/\\___|        ", SGR.BOLD);

    }
}
