package views;

import java.util.Scanner;
import java.util.regex.Matcher;

import controllers.MaintainerController;
import controllers.RegisterMenuController;
import models.Commands.RegisterMenuCommands;

public class RegisterMenu implements AppMenu {
    public static void printResult(String result) {
        System.out.println(result);
    }
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = RegisterMenuCommands.MENU_ENTER.regexMatcher(command);
        if (matcher.matches()) {
            String menuName = matcher.group("menuName");

            RegisterMenuController.ChangeMenu(menuName);
            return;
        }
        matcher = RegisterMenuCommands.LOADMAP.regexMatcher(command);
        if (matcher.matches()) {
            MaintainerController.loadMap();
            return;
        }

        matcher = RegisterMenuCommands.MENU_EXIT.regexMatcher(command);
        if (matcher.matches()) {
            RegisterMenuController.Exit();
            return;
        }

        matcher = RegisterMenuCommands.SHOW_CURRENT_MENU.regexMatcher(command);
        if (matcher.matches()) {
            RegisterMenuController.ShowCurrentMenu();
            return;
        }

        matcher = RegisterMenuCommands.REGISTER.regexMatcher(command);
        if (matcher.matches()) {
            RegisterMenuController.register(matcher, scanner);
            return;
        }
        System.out.println("Invalid command");
    }

}
