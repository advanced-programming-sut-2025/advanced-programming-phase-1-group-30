package AP.group30.StardewValley.views;

import java.util.Scanner;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Commands.Menus;

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
