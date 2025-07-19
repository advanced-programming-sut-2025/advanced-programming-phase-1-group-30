package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class RegisterMenuController {

    public static int register(String username, String password, String passwordConfirm, String email,
                               String nickname, String gender, String answer, String question) {
        for(User users : App.getAppUsers()){
            if(users.getUsername().equals(username)){
                RegisterMenu.printResult("Username is already in use!");
                return 0;
            }
        }

        if(!Pattern.compile("[A-Za-z0-9-]+").matcher(username).matches()){
            RegisterMenu.printResult("Username is invalid!");
            return 0;
        }

        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            RegisterMenu.printResult("Email is invalid!");
            return 0;
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()){
            RegisterMenu.printResult("Password is invalid!");
            return 0;
        }

        if(!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()){
            RegisterMenu.printResult("Password has to be at least 9 characters!");
            return 0;
        }

        if(!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()){
            RegisterMenu.printResult("Password has to have at least one Uppercase letter!");
            return 0;
        }

        if(!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()){
            RegisterMenu.printResult("Password has to have at least one Lowercase letter!");
            return 0;
        }

        if(!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
            RegisterMenu.printResult("Password has to have at least one digit!");
            return 0;
        }

        if(!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
            RegisterMenu.printResult("Password has to have at least one special character!");
            return 0;
        }

        if(!password.equals(passwordConfirm)){
            RegisterMenu.printResult("Passwords do not match!");
            return 0;
        }

        User newUser = new User(username, password, nickname, email, RegisterQuestions.getQuestion(question) , answer, gender);
        App.getAppUsers().add(newUser);
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
