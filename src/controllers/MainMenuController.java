package controllers;

import models.App;
import models.Commands.Menus;
import views.RegisterMenu;

public class MainMenuController {
    public static void logout() {
        App.setCurrentUser(null);
        RegisterMenu.printResult("User logged out successfully");
        App.setCurrentMenu(Menus.LoginMenu);
    }

    public static void ChangeMenu(String menuName) {
        String nameMenu = App.getCurrentMenu().getName();
        Menus menu = ProfileMenuController.FindMenu(menuName);
        if (menu == null ||nameMenu.equals(menuName)) {
            RegisterMenu.printResult("Invalid menu name");
            return;
        }
        RegisterMenu.printResult("Redirecting to " + menuName);
        App.setCurrentMenu(menu);
    }

    public static void ShowCurrentMenu() {
        RegisterMenu.printResult("Current menu: " + App.getCurrentMenu().getName());
    }
    
    public static void Exit() {
        App.setCurrentMenu(Menus.ExitMenu);
    }
}
