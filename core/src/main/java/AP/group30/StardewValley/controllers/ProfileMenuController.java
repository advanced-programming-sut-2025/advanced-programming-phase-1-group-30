package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.RegisterMenu;

import java.util.regex.Pattern;

public class ProfileMenuController {
    public static void ChangeUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername().equals(username)) {
                RegisterMenu.printResult("This username is already taken");
                return;
            }
        }
        if(!Pattern.compile("[A-Za-z0-9-]+").matcher(username).matches()){
            RegisterMenu.printResult("Username is invalid!");
            return;
        }
        App.getCurrentUser().setUsername(username);
        RegisterMenu.printResult("Changed username to " + username);
    }

    public static void ChangeNickname(String nickname) {
        if (App.getCurrentUser().getNickname().equals(nickname)) {
            RegisterMenu.printResult("Pick a different nickname");
            return;
        }
        App.getCurrentUser().setNickname(nickname);
        RegisterMenu.printResult("Changed nickname to " + nickname);
    }

    public static void ChangeEmail(String email) {
        for (User user : App.getAppUsers()) {
            if (user.getEmail().equals(email)) {
                RegisterMenu.printResult("This email is already taken");
                return;
            }
        }
        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            RegisterMenu.printResult("Email is invalid!");
            return;
        }
        App.getCurrentUser().setEmail(email);
        RegisterMenu.printResult("Email Changed");
    }

    public static void ChangePassword(String password, String oldPassword) {
        if (!App.getCurrentUser().getPassword().equals(oldPassword)) {
            RegisterMenu.printResult("Your old password is incorrect");
            return;
        }
        if (App.getCurrentUser().getPassword().equals(password)) {
            RegisterMenu.printResult("Your new password is the same as your old password");
            return;
        }
        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()){
            RegisterMenu.printResult("Password is invalid!");
            return;
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()){
            RegisterMenu.printResult("Password has to be at least 9 characters!");
            return;
        }

        if(!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()){
            RegisterMenu.printResult("Password has to have at least one Uppercase letter!");
            return;
        }

        if(!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()){
            RegisterMenu.printResult("Password has to have at least one Lowercase letter!");
            return;
        }

        if(!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
            RegisterMenu.printResult("Password has to have at least one digit!");
            return;
        }

        if(!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
            RegisterMenu.printResult("Password has to have at least one special character!");
            return;
        }
        App.getCurrentUser().setPassword(password);
        RegisterMenu.printResult("Password changed successfully");
    }

    public static void UserInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current user:\nName: " + App.getCurrentUser().getUsername() + "\n");
        sb.append("Nickname: " + App.getCurrentUser().getNickname() + "\n");
        sb.append("Email: " + App.getCurrentUser().getEmail() + "\n");
        sb.append("Max money in a Game: " + App.getCurrentUser().getMaxMoney() + "\n"); // TODO barresi shavad!
        sb.append("Number of games played: " + App.getCurrentUser().getNumOfGames());
        RegisterMenu.printResult(sb.toString());
    }

}
