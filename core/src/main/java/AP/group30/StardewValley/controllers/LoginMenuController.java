package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Users.RegisterQuestions;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.LoginMenu;
import AP.group30.StardewValley.views.RegisterMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    public static boolean Login(String username, String password, boolean stayLoggedInBoolean) {
        User user = getUserByUsername(username);
        if (App.getCurrentUser() != null) {
//            RegisterMenu.printResult("You are logged in as " + App.getCurrentUser().getUsername());
            LoginMenu.printResult("You are already logged in!");
            return false;
        }
        if (user == null) {
//            RegisterMenu.printResult("User not found");
            LoginMenu.printResult("User not found!");
            return false;
        }
        if (!user.getPassword().equals(RegisterMenuController.HashPassword(password))) {
//            RegisterMenu.printResult("Wrong password");
            LoginMenu.printResult("Wrong password!");
            return false;
        }
        App.setCurrentUser(user);    // TODO flag stay logged in ro ok kon!
//        App.setCurrentMenu(Menus.MainMenu);
//        RegisterMenu.printResult("User logged in");
//        RegisterMenu.printResult("Redirecting to main menu");
        LoginMenu.printResult("User logged in successfully!\nRedirecting to main menu");
        return true;
    }

    public static void ForgotPassword(String username, Scanner scanner) {  // TODO aval oon question taeed piade sazi shavad
        User user = getUserByUsername(username);
        if (user == null) {
            RegisterMenu.printResult("User not found");
            return;
        }

        int counter = 1;
        String registerQ = "";
//        for(RegisterQuestions questions : RegisterQuestions.values()){
//            if(counter == user.getRegisterQuestionNumber()){
//                registerQ = questions.question;
//            }
//            counter++;
//        }

        RegisterMenu.printResult("Enter the answer of the security question: \n" + registerQ);
        Matcher matcher;
        if ((matcher = Pattern.compile("answer\\s+-a\\s+(?<answer>.+?)\\s*").matcher(scanner.nextLine())).matches()) {
            if (matcher.group("answer").equals(user.getAnswer())) {
                RegisterMenu.printResult("choose a new password");
                while(true) {
                    String password = scanner.nextLine();

                    if (!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]*").matcher(password).matches()) {
                        RegisterMenu.printResult("Password is invalid!");
                        continue;
                    }

                    if (!Pattern.compile("[A-Za-z0-9?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]{9,}").matcher(password).matches()) {
                        RegisterMenu.printResult("Password has to be at least 9 characters!");
                        continue;
                    }

                    if (!Pattern.compile("(?=.*[A-Z]).*").matcher(password).matches()) {
                        RegisterMenu.printResult("Password has to have at least one Uppercase letter!");
                        continue;
                    }

                    if (!Pattern.compile("(?=.*[a-z]).*").matcher(password).matches()) {
                        RegisterMenu.printResult("Password has to have at least one Lowercase letter!");
                        continue;
                    }

                    if (!Pattern.compile("(?=.*[0-9]).*").matcher(password).matches()) {
                        RegisterMenu.printResult("Password has to have at least one digit!");
                        continue;
                    }

                    if (!Pattern.compile("(?=.*[?><,\"';\\\\:\\/|\\]\\[}{+=)(*&^%$#!]).*").matcher(password).matches()) {
                        RegisterMenu.printResult("Password has to have at least one special character!");
                        continue;
                    }
                    user.setPassword(password);
                    RegisterMenu.printResult("Successfully changed password");
                    return;
                }
            } else {
                RegisterMenu.printResult("Wrong answer");
            }
        } else {
            RegisterMenu.printResult("Invalid input format. Please use: answer -a <your_answer>");
        }
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
