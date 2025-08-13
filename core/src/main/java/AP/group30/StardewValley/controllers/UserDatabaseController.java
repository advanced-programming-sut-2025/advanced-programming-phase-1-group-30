package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDatabaseController {
    private static final String URL = "jdbc:sqlite:users.db";

    public UserDatabaseController() {
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                username TEXT PRIMARY KEY,
                password TEXT NOT NULL,
                nickname TEXT,
                email TEXT UNIQUE,
                maxMoney INTEGER,
                numOfGames INTEGER,
                gender TEXT,
                question TEXT,
                answer TEXT,
                isInGame INTEGER
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users(username, password, nickname, email, maxMoney, numOfGames, gender, question, answer, isInGame) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getNickname());
            pstmt.setString(4, user.getEmail());
            pstmt.setInt(5, user.getMaxMoney());
            pstmt.setInt(6, user.getNumOfGames());
            pstmt.setString(7, user.getGender());
            pstmt.setString(8, user.getQuestion().getQuestion());
            pstmt.setString(9, user.getAnswer());
            pstmt.setInt(10, user.isInGame() ? 1 : 0);

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("nickname"),
                    rs.getString("email"),
                    RegisterQuestions.getQuestion(rs.getString("question")),
                    rs.getString("answer"),
                    rs.getString("gender")
                );
                user.setMaxMoney(rs.getInt("maxMoney"));
                user.setNumOfGames(rs.getInt("numOfGames"));
                user.setInGame(rs.getInt("isInGame") == 1);
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("Error reading users: " + e.getMessage());
        }
        return users;
    }
}
