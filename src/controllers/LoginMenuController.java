package controllers;

import models.App;
import models.User;
import models.enums.Commands.Menus;

public class LoginMenuController {
    public static void Login(String username, String password) {
        User user = getUserByUsername(username);
        if (App.getCurrentUser() != null) {
            System.out.println("You are logged in as " + App.getCurrentUser().getUsername());
            return;
        }
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong password");
            return;
        }
        App.setCurrentUser(user);    // TODO flag stay logged in ro ok kon!
    }
    public static void ForgotPassword(String username) {  // TODO aval oon question taeed piade sazi shavad
    }
    public static void ChangeMenu(String menuName) {
        ProfileMenuController.FindMenu(menuName);
    }
    public static void ShowCurrentMenu() {
        System.out.println("Current menu: " + App.getCurrentMenu().getName());
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
