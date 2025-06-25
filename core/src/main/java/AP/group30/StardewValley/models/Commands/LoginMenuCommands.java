package AP.group30.StardewValley.models.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands {
    MENU_ENTER("^\\s*menu\\s+enter\\s+(?<menuName>.*\\S)\\s*$"),
    MENU_EXIT("^\\s*menu\\s+exit\\s*$"),
    SHOW_CURRENT_MENU("^\\s*show\\s+current\\s+menu\\s*$"),
    LOGIN("^\\s*login\\s+-u\\s+(?<username>.*\\S)\\s+-p\\s+(?<password>.*\\S)(?<stayLoggedIn>\\s+-stay-logged-in)?\\s*$"),
    FORGET_PASSWORD("^\\s*forget\\s+password\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    ANSWER("^\\s*answer\\s+-a\\s+(?<answer>.*\\S)\\s*$"),
    USER_LOGOUT("^\\s*user\\s+logout\\s*$");

    private final String commandRegex;
    LoginMenuCommands(String commandRegex){
        this.commandRegex = commandRegex;
    }

    public Matcher regexMatcher(String command){
        Pattern pattern = Pattern.compile(this.commandRegex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }
}
