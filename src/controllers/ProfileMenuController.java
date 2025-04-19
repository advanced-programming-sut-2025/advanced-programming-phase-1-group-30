package controllers;

import models.App;
import models.User;
import models.enums.Commands.Menus;

public class ProfileMenuController {
    public static String ChangeUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername().equals(username)) {
                return "This username is already taken";
            }
        }

        App.getCurrentUser().setUsername(username);
        return "Changed username to " + username;
    }
    public static String ChangeNickname(String nickname) {
        if (App.getCurrentUser().getNickname().equals(nickname)) {
            return "Pick a different nickname";
        }
        App.getCurrentUser().setNickname(nickname);
        return "Changed nickname to " + nickname;
    }
    public static String ChangeEmail(String email) {
        for (User user : App.getAppUsers()) {
            if (user.getEmail().equals(email)) {
                return "This email is already taken";
            }
        }
        App.getCurrentUser().setEmail(email);
        return "Email Changed";
    }
    public static String ChangePassword(String password, String oldPassword) {
        if (!App.getCurrentUser().getPassword().equals(oldPassword)) {
            return "Your old password is incorrect";
        }
        if (App.getCurrentUser().getPassword().equals(password)) {
            return "Your new password is the same as your old password";
        }
        App.getCurrentUser().setPassword(password);
        return "Password changed successfully";
    }
    public static void ChangeMenu(String menuName) {
        FindMenu(menuName);
    }

    public static void FindMenu(String menuName) {
        switch (menuName){
            case "Register Menu":  App.setCurrentMenu(Menus.RegisterMenu);
            case "Login Menu": App.setCurrentMenu(Menus.LoginMenu);
            case "Game Menu": App.setCurrentMenu(Menus.GameMenu);
            case "Profile Menu": App.setCurrentMenu(Menus.ProfileMenu);
            case "Main Menu": App.setCurrentMenu(Menus.MainMenu);
        }
    }

    public static String ShowCurrentMenu() {
        return "Current menu: " + App.getCurrentMenu().getName();
    }

    public static String UserInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current user:\nName " + App.getCurrentUser().getUsername() + "\n");
        sb.append("Nickname: " + App.getCurrentUser().getNickname() + "\n");
        sb.append("Email: " + App.getCurrentUser().getEmail() + "\n");
        sb.append("Max money in a Game: " + App.getCurrentUser().getMaxMoney() + "\n");
        sb.append("Number of games played: " + App.getCurrentUser().getNumOfGames());
        return sb.toString();
    }
    public static void Exit() {
        App.setCurrentMenu(Menus.ExitMenu);
    }
}
