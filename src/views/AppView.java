package views;

import java.util.Scanner;

import models.App;
import models.enums.Commands.Menus;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!App.getCurrentMenu().equals(Menus.ExitMenu)) {
            App.getCurrentMenu().checkCommand(command, scanner);

            command = scanner.nextLine();
        }

        scanner.close();
    }
}
