package models;

import models.enums.Commands.Menus;

import java.awt.*;
import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> appUsers = new ArrayList<>();
    private static Menus currentMenu;
    private static Game currentGame;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        App.currentUser = currentUser;
    }

    public static ArrayList<User> getAppUsers() {
        return appUsers;
    }

    public static void setAppUsers(ArrayList<User> appUsers) {
        App.appUsers = appUsers;
    }

    public static Menus getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menus currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        App.currentGame = currentGame;
    }
}
