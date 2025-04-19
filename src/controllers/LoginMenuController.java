package controllers;

import models.App;
import models.User;
import models.enums.Commands.Menus;

public class LoginMenuController {
    public static String Login(String username, String password, boolean stayLoggedInBoolean) {
        User user = getUserByUsername(username);
        if (App.getCurrentUser() != null) {
            return "You are logged in as " + App.getCurrentUser().getUsername();
        }
        if (user == null) {
            return "User not found";
        }
        if (!user.getPassword().equals(password)) {
            return "Wrong password";
        }
        App.setCurrentUser(user);    // TODO flag stay logged in ro ok kon!
        return "User logged in";
    }
    public static void ForgotPassword(String username) {  // TODO aval oon question taeed piade sazi shavad
    }
    public static void ChangeMenu(String menuName) {
        ProfileMenuController.FindMenu(menuName);
    }
    public static String ShowCurrentMenu() {
        return "Current menu: " + App.getCurrentMenu().getName();
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
