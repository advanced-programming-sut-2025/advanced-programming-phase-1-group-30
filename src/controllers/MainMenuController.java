package controllers;

import models.App;
import models.enums.Commands.Menus;
import views.RegisterMenu;

public class MainMenuController {
    public static void logout() {
        App.setCurrentUser(null);
        RegisterMenu.printResult("User logged out successfully");
    }
    public static void ChangeMenu(String menuName) {
        String nameMenu = App.getCurrentMenu().getName();
        // Menus menu = ProfileMenuController.FindMenu(menuName);
        if (nameMenu.equals(App.getCurrentMenu().getName())) {
            RegisterMenu.printResult("Invalid menu name");
            return;
        }
        RegisterMenu.printResult("Redirecting to " + menuName);
    }
    public static void ShowCurrentMenu() {
        RegisterMenu.printResult("Current menu: " + App.getCurrentMenu().getName());
    }
    public static void Exit() {
        App.setCurrentMenu(Menus.ExitMenu);
    }
}
