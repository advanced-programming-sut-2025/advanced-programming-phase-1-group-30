package views;

import java.util.regex.Matcher;

import controllers.ProfileMenuController;
import models.enums.Commands.ProfileMenuCommands;

public class ProfileMenu implements AppMenu {
    @Override
    public void check(String command) {
        Matcher matcher;

        matcher = ProfileMenuCommands.CHANGE_USERNAME.regexMatcher(command);
        if (matcher.matches()) {
            String username = matcher.group("username");

            ProfileMenuController.ChangeUsername(username);
            return;
        }

        matcher = ProfileMenuCommands.CHANGE_NICKNAME.regexMatcher(command);
        if (matcher.matches()) {
            String nickname = matcher.group("nickname");

            ProfileMenuController.ChangeNickname(nickname);
            return;
        }

        matcher = ProfileMenuCommands.CHANGE_EMAIL.regexMatcher(command);
        if (matcher.matches()) {
            String email = matcher.group("email");

            ProfileMenuController.ChangeEmail(email);
            return;
        }

        matcher = ProfileMenuCommands.CHANGE_PASSWORD.regexMatcher(command);
        if (matcher.matches()) {
            String newPassword = matcher.group("newPassword");
            String oldPassword = matcher.group("oldPassword");

            ProfileMenuController.ChangePassword(newPassword, oldPassword);
            return;
        }

        matcher = ProfileMenuCommands.USER_INFO.regexMatcher(command);
        if (matcher.matches()) {
            ProfileMenuController.UserInfo();
            return;
        }
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }
}
