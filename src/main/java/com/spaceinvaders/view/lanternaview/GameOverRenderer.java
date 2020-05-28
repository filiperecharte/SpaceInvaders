package com.spaceinvaders.view.lanternaview;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.spaceinvaders.view.lanternaview.imagesrederers.Renderer;

public class GameOverRenderer implements Renderer {
    @Override
    public void render(TextGraphics graphics) {
        graphics.fill(' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(7,2,"   _____          __  __ ______    ______      ________ _____  _ ");
        graphics.putString(7,3,"  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\| |");
        graphics.putString(7,4," | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) | |");
        graphics.putString(7,5," | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  /| |");
        graphics.putString(7,6," | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\|_|");
        graphics.putString(7,7,"  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_(_)");

        graphics.setForegroundColor(TextColor.Factory.fromString("#006400"));
        graphics.putString(14,11,"                         _              _           ");
        graphics.putString(14,12,"  ____ __  __ _ __ ___  | |_ ___   _ __| |__ _ _  _ ");
        graphics.putString(14,13," (_-< '_ \\/ _` / _/ -_) |  _/ _ \\ | '_ \\ / _` | || |");
        graphics.putString(14,14," /__/ .__/\\__,_\\__\\___|  \\__\\___/ | .__/_\\__,_|\\_, |");
        graphics.putString(14,15,"    |_|                           |_|          |__/ ");

        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.putString(18,16,"               _         _                          ");
        graphics.putString(18,17,"  ___ ___ __  | |_ ___  | |___ __ ___ _____         ");
        graphics.putString(18,18," / -_|_-</ _| |  _/ _ \\ | / -_) _` \\ V / -_)        ");
        graphics.putString(18,19," \\___/__/\\__|  \\__\\___/ |_\\___\\__,_|\\_/\\___|        ");

    }
}
