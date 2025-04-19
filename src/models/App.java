package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static User currentUser;
    private static ArrayList<User> appUsers = new ArrayList<>();
    private static ArrayList<String> questions = new ArrayList<>();
    private static Menu currentMenu;
    private static Game currentGame;

    public static ArrayList<User> getAppUsers() {
        return appUsers;
    }
    public static ArrayList<String> getQuestions() {return questions;}

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }
}
