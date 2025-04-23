package views;

import java.util.Scanner;

public class GameMenu implements AppMenu {
    public static void PrintResult(String message){
        System.out.println(message);
    }
    @Override
    public void check(String command, Scanner scanner) {
        throw new UnsupportedOperationException("Unimplemented method 'check'");
    }
}
