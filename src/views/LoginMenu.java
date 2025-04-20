package views;

import java.util.Scanner;
import java.util.regex.Matcher;

import controllers.LoginMenuController;
import models.enums.Commands.LoginMenuCommands;

public class LoginMenu implements AppMenu {
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = LoginMenuCommands.MENU_ENTER.regexMatcher(command);
        if (matcher.matches()) {
            String menuName = matcher.group("menuName");

            LoginMenuController.ChangeMenu(menuName);
            return;
        }

        matcher = LoginMenuCommands.MENU_EXIT.regexMatcher(command);
        if (matcher.matches()) {
            LoginMenuController.Exit();
            return;
        }

        matcher = LoginMenuCommands.SHOW_CURRENT_MENU.regexMatcher(command);
        if (matcher.matches()) {
            LoginMenuController.ShowCurrentMenu();
            return;
        }
        
        matcher = LoginMenuCommands.LOGIN.regexMatcher(command);
        if (matcher.matches()) {
            String username = matcher.group("username");
            String password = matcher.group("password");
            String stayLoggedIn = matcher.group("stayLoggedIn");
            boolean stayLoggedInBoolean;
            if (stayLoggedIn == null) stayLoggedInBoolean = false;
            else stayLoggedInBoolean = true;

            LoginMenuController.Login(username, password, stayLoggedInBoolean);
            return;
        }

        matcher = LoginMenuCommands.FORGET_PASSWORD.regexMatcher(command);
        if (matcher.matches()) {
            String username = matcher.group("username");
            LoginMenuController.ForgotPassword(username, scanner);
            return;
        }

        // TODO answer bayad dakhel forgot-password piadesazi shavad

        matcher = LoginMenuCommands.USER_LOGOUT.regexMatcher(command);
        if (matcher.matches()) {
            // LoginMenuController.Logout();
            return;
        }
    }
}
