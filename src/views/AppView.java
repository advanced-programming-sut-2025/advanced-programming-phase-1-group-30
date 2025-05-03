package views;

import java.util.Scanner;

import models.App;
import models.Commands.Menus;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            command = scanner.nextLine();
            App.getCurrentMenu().checkCommand(command, scanner);
        } while (!App.getCurrentMenu().equals(Menus.ExitMenu));

        scanner.close();
    }
}
