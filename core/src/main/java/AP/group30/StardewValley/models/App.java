package AP.group30.StardewValley.models;

//import AP.group30.StardewValley.models.Commands.Menus;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Users.User;

import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> appUsers = new ArrayList<>();
    private static ArrayList<Map> maps = new ArrayList<>();
    private static ArrayList<String> questions = new ArrayList<>();
//    private static Menus currentMenu = Menus.RegisterMenu;
    private static Game currentGame;
    private static ArrayList<Game> games = new ArrayList<>();

    public static ArrayList<String> getQuestions() {return questions;}

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

//    public static Menus getCurrentMenu() {
//        return currentMenu;
//    }

    public static ArrayList<Map> getMaps() {
        return maps;
    }

    public static void setMaps(ArrayList<Map> maps) {
        App.maps = maps;
    }

//    public static void setCurrentMenu(Menus currentMenu) {
//        App.currentMenu = currentMenu;
//    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        App.currentGame = currentGame;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }
}
