package AP.group30.StardewValley.models.SaveData;

import AP.group30.StardewValley.models.Users.RegisterQuestions;

public class SaveUser {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private int maxMoney;
    private int  numOfGames;
    private SavePlayer player;
    private String gender;
    private RegisterQuestions question;
    private String answer;
    private boolean isInGame;

    public SaveUser(String gender, RegisterQuestions question, String answer, String username, String password,
                    String nickname, String email, int maxMoney, int numOfGames, SavePlayer player, boolean isInGame) {
        this.gender = gender;
        this.question = question;
        this.answer = answer;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.maxMoney = maxMoney;
        this.numOfGames = numOfGames;
        this.player = player;
        this.isInGame = isInGame;
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

    public SavePlayer getPlayer() {
        return player;
    }

    public void setPlayer(SavePlayer player) {
        this.player = player;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public RegisterQuestions getQuestion() {
        return question;
    }

    public void setQuestion(RegisterQuestions question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isInGame() {
        return isInGame;
    }

    public void setInGame(boolean inGame) {
        isInGame = inGame;
    }
}
