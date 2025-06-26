package AP.group30.StardewValley.views;

import AP.group30.StardewValley.controllers.MainMenuController;
import AP.group30.StardewValley.controllers.ProfileMenuController;
import AP.group30.StardewValley.models.Commands.LoginMenuCommands;
import AP.group30.StardewValley.models.Commands.ProfileMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu implements AppMenu {
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = LoginMenuCommands.USER_LOGOUT.regexMatcher(command);
        if (matcher.matches()) {
            MainMenuController.logout();
            return;
        }
        System.out.println("Invalid command");
    }
}
