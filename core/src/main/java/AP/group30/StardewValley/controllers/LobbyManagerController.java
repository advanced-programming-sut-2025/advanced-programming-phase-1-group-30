package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Lobby;

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

    private static boolean isIdUsed(int id) {
        for (Lobby lobby : App.getLobbies()) {
            if (lobby.getLobbyID() == id) return true;
        }

        return false;
    }
}
