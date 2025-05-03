package views;

import controllers.MainMenuController;
import controllers.ProfileMenuController;
import models.Commands.LoginMenuCommands;
import models.Commands.ProfileMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu implements AppMenu {
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = ProfileMenuCommands.MENU_ENTER.regexMatcher(command);
        if (matcher.matches()) {
            String menuName = matcher.group("menuName");

            ProfileMenuController.ChangeMenu(menuName);
            return;
        }

        matcher = ProfileMenuCommands.MENU_EXIT.regexMatcher(command);
        if (matcher.matches()) {
            ProfileMenuController.Exit();
            return;
        }

        matcher = ProfileMenuCommands.SHOW_CURRENT_MENU.regexMatcher(command);
        if (matcher.matches()) {
            ProfileMenuController.ShowCurrentMenu();
            return;
        }

        matcher = LoginMenuCommands.USER_LOGOUT.regexMatcher(command);
        if (matcher.matches()) {
            MainMenuController.logout();
        }
    }
}
