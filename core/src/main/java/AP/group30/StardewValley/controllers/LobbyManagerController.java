package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.User;

import java.util.Random;

public class LobbyManagerController {
    public static boolean findLobby(int lobbyID) {
        for (Lobby lobby : App.getLobbies()) {
            if (lobby.getLobbyID() == lobbyID) {
                App.setCurrentLobby(lobby);
                lobby.addUser(App.getCurrentUser());

                return true;
            }
        }

        return false;
    }

    public static void createLobby() {
        Random rand = new Random();
        int id = rand.nextInt(100000);

        while (isIdUsed(id)) {
            id = rand.nextInt(100000);
        }

        Lobby lobby = new Lobby(id, App.getCurrentUser());

        App.addLobby(lobby);
        App.setCurrentLobby(lobby);
    }

    public static int addUser(String username) {
        User user = User.findUserByUsername(username);

        if (user == null) return 0;

        if (user.equals(App.getCurrentUser())) return 1;

        if (user.isInGame()) return 2;

        for (User lobbyUser : App.getCurrentLobby().getUsers()) {
            if (user.equals(lobbyUser)) return 3;
        }

        App.getCurrentLobby().addUser(user);
        return 4;
    }

    private static boolean isIdUsed(int id) {
        for (Lobby lobby : App.getLobbies()) {
            if (lobby.getLobbyID() == id) return true;
        }

        return false;
    }
}
