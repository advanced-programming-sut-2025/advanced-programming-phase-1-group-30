package views;

import java.util.Scanner;
import java.util.regex.Matcher;

import controllers.NewGameController;
import models.enums.Commands.GameMenuCommands;

public class GameMenu implements AppMenu {
    public static void printResult(String result) {
        System.out.println(result);
    }
    @Override
    public void check(String command, Scanner scanner) {
        Matcher matcher;

        matcher = GameMenuCommands.GAME_NEW.regexMatcher(command);
        if (matcher.matches()) {
            String username1 = matcher.group("username1");
            String username2 = matcher.group("username2");
            String username3 = matcher.group("username3");

            NewGameController.NewGame(username1, username2, username3, scanner);
            return;
        }
    }
}
