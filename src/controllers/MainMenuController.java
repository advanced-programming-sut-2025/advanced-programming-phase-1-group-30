package controllers;

import models.App;
import models.enums.Commands.Menus;

public class MainMenuController {
    public static String logout() {
        App.setCurrentUser(null);
        return "User logged out successfully";
    }
    public static void ChangeMenu(String menuName) {
        ProfileMenuController.FindMenu(menuName);
    }
    public static String ShowCurrentMenu() {
        return App.getCurrentMenu().getName();
    }
    public static void Exit() {
        App.setCurrentMenu(Menus.ExitMenu);
    }
}
