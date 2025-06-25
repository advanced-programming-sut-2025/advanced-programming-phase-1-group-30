package AP.group30.StardewValley.models.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterMenuCommands {
    MENU_ENTER("^\\s*menu\\s+enter\\s+(?<menuName>.*\\S)\\s*$"),
    MENU_EXIT("^\\s*menu\\s+exit\\s*$"),
    LOADMAP("^load map$"),
    SHOW_CURRENT_MENU("^\\s*show\\s+current\\s+menu\\s*$"),
    REGISTER("^\\s*register\\s+-u\\s+(?<username>.*\\S)\\s+-p\\s+(?<password>.*\\S)\\s+(?<passwordConfirm>.*\\S)\\s+-n\\s+(?<nickname>.*\\S)\\s+-e\\s+(?<email>.*\\S)\\s+-g\\s+(?<gender>.*\\S)\\s*$"),
    PICK_QUESTION("^\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>.*\\S)\\s+-a\\s+(?<answer>.*\\S)\\s+-c\\s+(?<answerConfirm>.*\\S)\\s*$");

    private final String commandRegex;
    RegisterMenuCommands(String commandRegex){
        this.commandRegex = commandRegex;
    }

    public Matcher regexMatcher(String command){
        Pattern pattern = Pattern.compile(this.commandRegex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }
}
