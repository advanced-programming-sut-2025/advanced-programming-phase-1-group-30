package AP.group30.StardewValley.models;

import AP.group30.StardewValley.models.Users.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Lobby {
    private final String lobbyID;

    private final ArrayList<String> users;
    private final ArrayList<Integer> maps;
    private final ArrayList<Boolean> readies;
    private final String admin;

    private boolean goToPreGame;
    private boolean goToMainGame;

    public Lobby(String lobbyID, String admin) {
        this.lobbyID = lobbyID;
        this.users = new ArrayList<>();
        this.maps = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        this.readies = new ArrayList<>(Arrays.asList(true, false, false, false));
        this.users.add(admin);
        this.admin = admin;
        this.goToPreGame = false;
        this.goToMainGame = false;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void addUser(String user) {
        users.add(user);
    }

    public void removeUser(String user) {
        users.remove(user);
    }

    public String getAdmin() {
        return admin;
    }

    public boolean isGoToPreGame() {
        return goToPreGame;
    }

    public void setGoToPreGame(boolean goToPreGame) {
        this.goToPreGame = goToPreGame;
    }

    public ArrayList<Integer> getMaps() {
        return maps;
    }

    public void changeMap(int index, int number) {
        maps.set(index, number);
    }

    public ArrayList<Boolean> getReadies() {
        return readies;
    }

    public void changeReady(int index) {
        readies.set(index, true);
    }

    public boolean isGoToMainGame() {
        return goToMainGame;
    }

    public void setGoToMainGame(boolean goToMainGame) {
        this.goToMainGame = goToMainGame;
    }
}
