package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.ProfileMenu;

import java.util.regex.Pattern;

public class ProfileMenuController {
    public static void changeInfo(String username, String email, String nickname) {
        if(!username.equals(App.getCurrentUser().getUsername()))
            ProfileMenu.printResultInfo(ChangeUsername(username));
        if(!email.equals(App.getCurrentUser().getEmail()))
            ProfileMenu.printResultInfo(ChangeEmail(email));
        if(!nickname.equals(App.getCurrentUser().getNickname()))
            ProfileMenu.printResultInfo(ChangeNickname(nickname));
    }

    public static void changePass(String oldPass, String newPass, String confirmNewPass) {
        if(newPass.equals(confirmNewPass))
            ProfileMenu.printResultPassword(ChangePassword(newPass, oldPass));
        else
            ProfileMenu.printResultPassword("Confirm Password is incorrect");
    }

    public static String ChangeUsername(String username) {
        for (User user : App.getAppUsers()) {
            if (user.getUsername().equals(username)) {
                return "This username is already taken";
            }
        }
        if(!Pattern.compile("[A-Za-z0-9-]+").matcher(username).matches()){
            return "Username is invalid!";
        }
        App.getCurrentUser().setUsername(username);
        return "";
    }

    public static String ChangeNickname(String nickname) {
        if (App.getCurrentUser().getNickname().equals(nickname)) {
            return "Pick a different nickname";
        }
        App.getCurrentUser().setNickname(nickname);
        return "";
    }

    public static String ChangeEmail(String email) {
        for (User user : App.getAppUsers()) {
            if (user.getEmail().equals(email)) {
                return "This email is already taken";
            }
        }
        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            return "Email is invalid!";
        }
        App.getCurrentUser().setEmail(email);
        return "";
    }

    public static String ChangePassword(String password, String oldPassword) {
        if (!App.getCurrentUser().getPassword().equals(oldPassword)) {
            return "Your old password is incorrect";
        }
        if (App.getCurrentUser().getPassword().equals(password)) {
            return "Your new password is the same as your old password";
        }
        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()){
            return "Password is invalid!";
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()){
            return "Password has to be at least 9 characters!";
        }

        if(!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()){
            return "Password has to have at least one Uppercase letter!";
        }

        if(!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()){
            return "Password has to have at least one Lowercase letter!";
        }

        if(!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
            return "Password has to have at least one digit!";
        }

        if(!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
            return "Password has to have at least one special character!";
        }
        App.getCurrentUser().setPassword(password);
        return "";
    }


}
