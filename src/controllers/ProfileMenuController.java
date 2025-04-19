package controllers;

import models.App;
import models.User;
import models.enums.Commands.Menus;

public class ProfileMenuController {
    public static void ChangeUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername().equals(username)) {
                System.out.println("This username is already taken");
                return;
            }
        }

        App.getCurrentUser().setUsername(username);
        System.out.println("Changed username to " + username);
    }
    public static void ChangeNickname(String nickname) {
        if (App.getCurrentUser().getNickname().equals(nickname)) {
            System.out.println("Pick a different nickname");
        }
        App.getCurrentUser().setNickname(nickname);
        System.out.println("Changed nickname to " + nickname);
    }
    public static void ChangeEmail(String email) {
        for (User user : App.getAppUsers()) {
            if (user.getEmail().equals(email)) {
                System.out.println("This email is already taken");
                return;
            }
        }
        App.getCurrentUser().setEmail(email);
    }
    public static void ChangePassword(String password, String oldPassword) {
        if (!App.getCurrentUser().getPassword().equals(oldPassword)) {
            System.out.println("Your old password is incorrect");
            return;
        }
        if (App.getCurrentUser().getPassword().equals(password)) {
            System.out.println("Your new password is the same as your old password");
        }
        App.getCurrentUser().setPassword(password);
        System.out.println("Password changed successfully");
    }
    public static void ChangeMenu(String menuName) {
        FindMenu(menuName);
    }

    public static void FindMenu(String menuName) {
        switch (menuName){
            case "Register Menu" -> App.setCurrentMenu(Menus.RegisterMenu);
            case "Login Menu" -> App.setCurrentMenu(Menus.LoginMenu);
            case "Game Menu" -> App.setCurrentMenu(Menus.GameMenu);
            case "Profile Menu" -> App.setCurrentMenu(Menus.ProfileMenu);
            case "Main Menu" -> App.setCurrentMenu(Menus.MainMenu);
        }
    }

    public static void ShowCurrentMenu() {
        System.out.println("Current menu: " + App.getCurrentMenu().getName());
    }

    public static void UserInfo() {
        System.out.println("Current user:\nName: " + App.getCurrentUser().getUsername());
        System.out.println("Nickname: " + App.getCurrentUser().getNickname());
        System.out.println("Email: " + App.getCurrentUser().getEmail());
        System.out.println("Max money in a Game: " + App.getCurrentUser().getMaxMoney());
        System.out.println("Number of games played: " + App.getCurrentUser().getNumOfGames());
    }
    public static void Exit() {}
}
