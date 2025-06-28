package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.MainMenu;
import AP.group30.StardewValley.views.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.util.regex.Pattern;

public class ProfileMenuController {
    public static void checkButton(TextButton button, TextButton backButton, TextButton changePassButton,
                                   Label errorPassword, Label errorLabel, TextField passField, TextField oldPass,
                                   TextField confirmPassField, TextField usernameField, TextField emailField,
                                   TextField nicknameField) {
        if(backButton.isPressed()){
            Main.getMain().setScreen(new MainMenu(new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"))));
            return;
        }

        if(changePassButton.isPressed()){
            errorPassword.setText(ChangePassword(passField.getText(), oldPass.getText()));
            errorPassword.setVisible(true);
        }

        if(button.isPressed()){
            if(!usernameField.getText().equals(App.getCurrentUser().getUsername())){
                errorLabel.setText(ChangeUsername(usernameField.getText()));
                errorLabel.setVisible(true);
            }
            if(!emailField.getText().equals(App.getCurrentUser().getEmail())){
                errorLabel.setText(ChangeEmail(emailField.getText()));
                errorLabel.setVisible(true);
            }
            if(!nicknameField.getText().equals(App.getCurrentUser().getNickname())){
                errorLabel.setText(ChangeNickname(nicknameField.getText()));
                errorLabel.setVisible(true);
            }
        }
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
        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            return "Email is invalid!";
        }
        App.getCurrentUser().setEmail(email);
        return "Changed email to " + email;
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
        return "Password changed successfully!";
    }


}
