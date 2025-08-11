package AP.group30.StardewValley.models;

//import AP.group30.StardewValley.models.Commands.Menus;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Players.PlayerLeaderboard;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.network.NetworkClient;
import AP.group30.StardewValley.views.CityScreen;

import java.util.ArrayList;

public class App {
    private static User currentUser;
    private static ArrayList<User> appUsers = new ArrayList<>();
    private static ArrayList<Map> maps = new ArrayList<>();
    private static ArrayList<String> questions = new ArrayList<>();
//    private static Menus currentMenu = Menus.RegisterMenu;
    private static Game currentGame;

    private static ArrayList<Game> games = new ArrayList<>();

    private static Lobby currentLobby = null;
    private static ArrayList<Lobby> lobbies = new ArrayList<>();

    private static NetworkClient networkClient; // Add this line

    private static final ArrayList<PlayerLeaderboard> playerLeaderboards = new ArrayList<>();

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

    public static Lobby getCurrentLobby() {
        return currentLobby;
    }

    public static void setCurrentLobby(Lobby currentLobby) {
        App.currentLobby = currentLobby;
    }

    public static ArrayList<Lobby> getLobbies() {
        return lobbies;
    }

    public static void addLobby(Lobby lobby) {
        lobbies.add(lobby);
    }

    public static void removeLobby(Lobby lobby) {
        lobbies.remove(lobby);
    }

    public static NetworkClient getNetworkClient() {
        return networkClient;
    }

    public static void setNetworkClient(NetworkClient client) {
        networkClient = client;
    }

    public static ArrayList<PlayerLeaderboard> getPlayerLeaderboards() {
        return playerLeaderboards;
    }

    public static void addPlayerLeaderboard(PlayerLeaderboard playerLeaderboard) {
        PlayerLeaderboard wantedPlayerLeaderboard = null;
        for (PlayerLeaderboard playerLeaderboard1 : playerLeaderboards) {
            if (playerLeaderboard1.getUsername().equals(playerLeaderboard.getUsername())) {
                wantedPlayerLeaderboard = playerLeaderboard1;
                break;
            }
        }

        if (wantedPlayerLeaderboard != null) {
            wantedPlayerLeaderboard.setMoney(playerLeaderboard.getMoney());
            wantedPlayerLeaderboard.setFarming(playerLeaderboard.getFarming());
            wantedPlayerLeaderboard.setMining(playerLeaderboard.getMining());
            wantedPlayerLeaderboard.setFishing(playerLeaderboard.getFishing());
            wantedPlayerLeaderboard.setForaging(playerLeaderboard.getForaging());
            wantedPlayerLeaderboard.setNumberOfQuests(playerLeaderboard.getNumberOfQuests());
        }
        else {
            playerLeaderboards.add(playerLeaderboard);
        }
    }
}
