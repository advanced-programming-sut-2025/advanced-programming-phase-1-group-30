package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.ChangePassMenu;
import AP.group30.StardewValley.views.LoginMenu;
import AP.group30.StardewValley.views.RegisterMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    public static boolean Login(String username, String password, boolean stayLoggedInBoolean) {
        User user = getUserByUsername(username);
        if (App.getCurrentUser() != null) {
            LoginMenu.printResult("You are already logged in!");
            return false;
        }
        if (user == null) {
            LoginMenu.printResult("User not found!");
            return false;
        }
        if (!user.getPassword().equals(RegisterMenuController.HashPassword(password))) {
            LoginMenu.printResult("Wrong password!");
            return false;
        }
        App.setCurrentUser(user);
        LoginMenu.printResult("User logged in successfully!\nRedirecting to main menu");
        return true;
    }

    public static User userVerify(String username){
        User user = getUserByUsername(username);
        if (user == null) {
            ChangePassMenu.printResult("User not found");
            return null;
        }

        return user;
    }

    public static boolean answerQuestion(String username, String answer) {
        User user = getUserByUsername(username);

        assert user != null;
        if (answer.equals(user.getAnswer()))
            return true;

        ChangePassMenu.printResult("Wrong answer!");
        return false;
    }

    public static boolean changePassword(String username, String password, String confirmPassword) {
        User user = LoginMenuController.getUserByUsername(username);

        if (!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()) {
            ChangePassMenu.printResult("Password is invalid!");
            return false;
        }

        if (!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()) {
            ChangePassMenu.printResult("Password has to be at least 9 characters!");
            return false;
        }

        if (!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()) {
            ChangePassMenu.printResult("Password has to have at least one Uppercase letter!");
            return false;
        }

        if (!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()) {
            ChangePassMenu.printResult("Password has to have at least one Lowercase letter!");
            return false;
        }

        if (!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
            ChangePassMenu.printResult("Password has to have at least one digit!");
            return false;
        }

        if (!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
            ChangePassMenu.printResult("Password has to have at least one special character!");
            return false;
        }

        assert user != null;
        user.setPassword(password);
        return true;
    }

    private static User getUserByUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername() != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
