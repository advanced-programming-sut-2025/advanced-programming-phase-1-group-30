package controllers;

import models.App;
import models.Commands.Menus;
import models.Commands.RegisterMenuCommands;
import models.Users.RegisterQuestions;
import models.Users.User;
import views.RegisterMenu;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenuController {

    public static void register(Matcher matcher, Scanner scanner) {
        String username = matcher.group("username").trim();
        String password = matcher.group("password").trim();
        String passwordConfirm = matcher.group("passwordConfirm").trim();
        String nickname = matcher.group("nickname").trim();
        String email = matcher.group("email").trim();
        String gender = matcher.group("gender").trim();

        for(User users : App.getAppUsers()){
            if(users.getUsername().equals(username)){
                RegisterMenu.printResult("Username is already in use!");
                return;
            }
        }

        if(!Pattern.compile("[A-Za-z0-9-]+").matcher(username).matches()){
            RegisterMenu.printResult("Username is invalid!");
            return;
        }

        if(!Pattern.compile("^[A-Za-z0-9](?!.*\\.\\.)[A-Za-z0-9._-]*[A-Za-z0-9]@[A-Za-z0-9][A-Za-z0-9-]*\\.[A-Za-z0-9-]+[A-Za-z0-9]$").matcher(email).matches()){
            RegisterMenu.printResult("Email is invalid!");
            return;
        }

        if(password.equals("random")){
            while(true){
                password = RandomPasswordGenerator();
                passwordConfirm = password;
                RegisterMenu.printResult("Your password is: " + password + "\nDo you want to confirm it? (Yes/No)");

                if(scanner.next().equals("Yes")){
                    break;
                }
            }
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

        if(!password.equals(passwordConfirm)){
            RegisterMenu.printResult("Passwords do not match!");
            return;
        }

        RegisterMenu.printResult("Ok answer a question!");

        int number = 1;
        for(RegisterQuestions registerQuestions : RegisterQuestions.values()){
            RegisterMenu.printResult(number + "- " + registerQuestions.question + "\n");
            number++;
        }

        String answer;
        String confirmAnswer;
        int questionIndex;

        while (true){
            String pickQuestion = scanner.nextLine();
            Matcher matcherQuestion;

            if ((matcherQuestion = RegisterMenuCommands.PICK_QUESTION.regexMatcher(pickQuestion)).matches()) {
                questionIndex = Integer.parseInt(matcherQuestion.group("questionNumber").trim());
                answer = matcherQuestion.group("answer").trim();
                confirmAnswer = matcherQuestion.group("answerConfirm").trim();
                if (!answer.equals(confirmAnswer)) {
                    RegisterMenu.printResult("Answers do not match!");
                }else{
                    break;
                }

            } else {
                RegisterMenu.printResult("invalid command!");
            }
        }

        User newUser = new User(username,password,nickname,email,questionIndex,answer,gender);
        App.getAppUsers().add(newUser);
        RegisterMenu.printResult("User created successfully!");
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

    public static void ChangeMenu(String menuName) {
        LoginMenuController.ChangeMenu(menuName);
    }

    public static void ShowCurrentMenu() {
        RegisterMenu.printResult("Current menu: " + App.getCurrentMenu().getName());
    }

    public static void Exit() {
        App.setCurrentMenu(Menus.MainMenu);
    }
}
