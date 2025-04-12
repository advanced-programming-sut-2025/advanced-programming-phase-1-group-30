package models;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int maxMoney;
    private int  numOfGames;
    private Player player;

    public User(String username, String password, String nickname, String email, int maxMoney, Player player, int numOfGames) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.maxMoney = maxMoney;
        this.player = player;
        this.numOfGames = numOfGames;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
