package views;

import java.util.Scanner;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        ExitMenu exitMenu = new ExitMenu();
        GameMenu gameMenu = new GameMenu();
        LoginMenu loginMenu = new LoginMenu();
        MainMenu mainMenu = new MainMenu();
        ProfileMenu profileMenu = new ProfileMenu();
        RegisterMenu registerMenu = new RegisterMenu();
    }
}
