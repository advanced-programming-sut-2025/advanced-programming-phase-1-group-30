package AP.group30.StardewValley.models;

import AP.group30.StardewValley.models.Users.User;

import java.util.ArrayList;

public class Lobby {
    private final int lobbyID;

    private final ArrayList<User> users;
    private final User admin;

    public Lobby(int lobbyID, User admin) {
        this.lobbyID = lobbyID;
        this.users = new ArrayList<>();
        this.admin = admin;
    }

    public int getLobbyID() {
        return lobbyID;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getAdmin() {
        return admin;
    }
}
