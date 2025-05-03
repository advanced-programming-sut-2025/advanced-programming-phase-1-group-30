package models.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileMenuCommands {
    MENU_ENTER("^\\s*menu\\s+enter\\s+(?<menuName>.*\\S)\\s*$"),
    MENU_EXIT("^\\s*menu\\s+exit\\s*$"),
    SHOW_CURRENT_MENU("^\\s*show\\s+current\\s+menu\\s*$"),
    CHANGE_USERNAME("^\\s*change\\s+username\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    CHANGE_NICKNAME("^\\s*change\\s+nickname\\s+-u\\s+(?<nickname>.*\\S)\\s*$"),
    CHANGE_EMAIL("^\\s*change\\s+email\\s+-e\\s+(?<email>.*\\S)\\s*$"),
    CHANGE_PASSWORD("^\\s*change\\s+password\\s+-p\\s+(?<newPassword>.*\\S)\\s+-o\\s+(?<oldPassword>.*\\S)\\s*$"),
    USER_INFO("^\\s*user\\s+info\\s*$");

    private final String commandRegex;
    ProfileMenuCommands(String commandRegex){
        this.commandRegex = commandRegex;
    }

    public Matcher regexMatcher(String command){
        Pattern pattern = Pattern.compile(this.commandRegex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }
}
