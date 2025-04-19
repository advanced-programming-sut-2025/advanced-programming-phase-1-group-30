package views;

import java.util.Scanner;

import models.App;

public class AppView {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (command != "exit") {
            App.getCurrentMenu().checkCommand(command);

            command = scanner.nextLine();
        }

        scanner.close();
    }
}
