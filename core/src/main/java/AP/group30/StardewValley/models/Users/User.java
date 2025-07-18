package AP.group30.StardewValley.models.Users;

import AP.group30.StardewValley.controllers.RegisterMenuController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.Players.Player;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int maxMoney;
    private int  numOfGames;
    private Player player;
    private final String gender;
    private final RegisterQuestions question;
    private final String answer;
    private boolean isInGame;

    public User(String username, String password, String nickname, String email, RegisterQuestions registerQuestion,
                String answer, String gender) {
        this.username = username;
        this.password = RegisterMenuController.HashPassword(password);
        this.nickname = nickname;
        this.email = email;
        this.numOfGames = 0;
        this.gender = gender;
        this.answer = answer;
        this.question = registerQuestion;
        this.isInGame = false;
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
        this.password = RegisterMenuController.HashPassword(password);
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

    public String getGender() {
        return gender;
    }

    public RegisterQuestions getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isInGame() {
        return isInGame;
    }

    public void changeInGame() {
        this.isInGame = !this.isInGame;
    }

    public static User findUserByUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername().equals(username)) return user;
        }

        return null;
    }
}
