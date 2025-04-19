package controllers;

import models.App;

public class MainMenuController {
    public static void logout() {
        App.setCurrentUser(null);
        System.out.println("User logged out successfully");
    }
    public static void ChangeMenu(String menuName) {
        ProfileMenuController.FindMenu(menuName);
    }
    public static void ShowCurrentMenu() {
        System.out.println(App.getCurrentMenu().getName());
    }
    public static void Exit() {}
}
