package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.LoginMenu;
import AP.group30.StardewValley.views.RegisterMenu;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class RegisterMenuController {

    public static int register(Button button, TextField usernameF, TextField passwordF, TextField confirmPass, TextField emailField, TextField nicknameF, Label errorLabel, String selectedGender, TextField answerField) {
        String username = usernameF.getText();
        String password = passwordF.getText();
        String passwordConfirm = confirmPass.getText();
        String nickname = nicknameF.getText();
        String email = emailField.getText();
        String gender = selectedGender;
        String answer = answerField.getText();

        for(User users : App.getAppUsers()){
            if(users.getUsername().equals(username)){
                errorLabel.setText("Username is already in use!");
                errorLabel.setVisible(true);
                return 0;
            }
        }

        if(!Pattern.compile("[A-Za-z0-9-]+").matcher(username).matches()){
            errorLabel.setText("Username is invalid!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            errorLabel.setText("Email is invalid!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()){
            errorLabel.setText("Password is invalid!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()){
            errorLabel.setText("Password has to be at least 9 characters!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()){
            errorLabel.setText("Password has to have at least one Uppercase letter!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()){
            errorLabel.setText("Password has to have at least one Lowercase letter!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
            errorLabel.setText("Password has to have at least one digit!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
            errorLabel.setText("Password has to have at least one special character!");
            errorLabel.setVisible(true);
            return 0;
        }

        if(!password.equals(passwordConfirm)){
            errorLabel.setText("Passwords do not match!");
            errorLabel.setVisible(true);
            return 0;
        }


        System.out.println(password);
        System.out.println(passwordConfirm);

        User newUser = new User(username, password, nickname, email, answer, gender);
        App.getAppUsers().add(newUser);
        App.setCurrentUser(newUser);
        errorLabel.setText("User created successfully!");
        errorLabel.setVisible(true);

        return 1;
    }

    public static String RandomPasswordGenerator() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        int length = random.nextInt(15 - 9 + 1 ) + 9;

        for (int i = 0; i <= length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    public static String HashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
