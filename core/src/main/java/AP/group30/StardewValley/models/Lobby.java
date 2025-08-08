package AP.group30.StardewValley.models;

import AP.group30.StardewValley.models.Users.User;

import java.util.ArrayList;

public class Lobby {
    private final String lobbyID;

    private final ArrayList<String> users;
    private final String admin;

    public Lobby(String lobbyID, String admin) {
        this.lobbyID = lobbyID;
        this.users = new ArrayList<>();
//        this.users.add(admin);
        this.admin = admin;
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

    public void removeUser(User user) {
        users.remove(user);
    }

    public String getAdmin() {
        return admin;
    }
}
