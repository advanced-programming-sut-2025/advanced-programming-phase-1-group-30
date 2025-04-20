package controllers;

import models.App;
import models.User;
import models.enums.Commands.Menus;
import views.RegisterMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    public static void Login(String username, String password, boolean stayLoggedInBoolean) {
        User user = getUserByUsername(username);
        if (App.getCurrentUser() != null) {
            RegisterMenu.printResult("You are logged in as " + App.getCurrentUser().getUsername());
            return;
        }
        if (user == null) {
            RegisterMenu.printResult("User not found");
            return;
        }
        if (!user.getPassword().equals(password)) {
            RegisterMenu.printResult("Wrong password");
            return;
        }
        App.setCurrentUser(user);    // TODO flag stay logged in ro ok kon!
        RegisterMenu.printResult("User logged in");
    }
    public static void ForgotPassword(String username, Scanner scanner) {  // TODO aval oon question taeed piade sazi shavad
        User user = getUserByUsername(username);
        if (user == null) {
            RegisterMenu.printResult("User not found");
            return;
        }
        RegisterMenu.printResult("Enter the answer of the security question: ");
        Matcher matcher;
        if ((matcher = Pattern.compile("answer\\s+-a\\s+(?<answer>.+?)\\s*").matcher(scanner.nextLine())).matches()) {
            if (matcher.group("answer").equals(user.getAnswer())) {
                RegisterMenu.printResult("Your password is: " + user.getPassword());
            } else {
                RegisterMenu.printResult("Wrong answer");
            }
        }
    }
    public static void ChangeMenu(String menuName) {
        ProfileMenuController.FindMenu(menuName);
        RegisterMenu.printResult("Redirecting to " + menuName);
    }
    public static void ShowCurrentMenu() {
        RegisterMenu.printResult("Current menu: " + App.getCurrentMenu().getName());
    }
    public static void Exit() {
        App.setCurrentMenu(Menus.ExitMenu);
    }
    private static User getUserByUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
