package models.Commands;

import views.*;

import java.util.Scanner;

public enum Menus {
    LoginMenu(new LoginMenu(), "Login Menu"),
    MainMenu(new MainMenu(), "Main Menu"),
    ProfileMenu(new ProfileMenu(), "Profile Menu"),
    RegisterMenu(new RegisterMenu(), "Register Menu"),
    GameMenu(new GameMenu(), "Game Menu"),
    ExitMenu(new ExitMenu(), "Exit Menu"),;
    private final AppMenu menu;
    private final String name;
    Menus(AppMenu menu, String name) {
        this.menu = menu;
        this.name = name;
    }
    public void checkCommand(String command, Scanner scanner) {
        this.menu.check(command, scanner);
    }

    public String getName() {
        return name;
    }
}
