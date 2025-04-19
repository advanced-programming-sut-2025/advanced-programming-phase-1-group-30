package views;

import java.util.regex.Matcher;

import controllers.RegisterMenuController;
import models.enums.Commands.RegisterMenuCommands;

public class RegisterMenu implements AppMenu {
    @Override
    public void check(String command) {
        Matcher matcher;

        matcher = RegisterMenuCommands.MENU_ENTER.regexMatcher(command);
        if (matcher.matches()) {
            String menuName = matcher.group("menuName");

            System.out.println(RegisterMenuController.changeMenu(menuName));
            return;
        }

        matcher = RegisterMenuCommands.MENU_EXIT.regexMatcher(command);
        if (matcher.matches()) {
            System.out.println(RegisterMenuController.exit());
            return;
        }

        matcher = RegisterMenuCommands.SHOW_CURRENT_MENU.regexMatcher(command);
        if (matcher.matches()) {
            System.out.println(RegisterMenuController.showCurrentMenu());
            return;
        }

        matcher = RegisterMenuCommands.REGISTER.regexMatcher(command);
        if (matcher.matches()) {
            String username = matcher.group("username");
            String password = matcher.group("password");
            String passwordConfirm = matcher.group("passwordConfirm");
            String nickname = matcher.group("nickname");
            String email = matcher.group("email");
            String gender = matcher.group("gender");

            System.out.println(RegisterMenuController.register(username, passwordConfirm, password, nickname, email, gender));
            return;
        }
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }
}
