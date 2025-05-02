package models.enums.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands {
    GAME_NEW("^\\s*game\\s+new\\s*(-u\\s+(?<username1>.*\\S))?(\\s+(?<username2>.*\\S))?(\\s+(?<username3>.*\\S))?\\s*$"),
    GAME_MAP("^\\s*game\\s+map\\s+(?<mapNumber>\\d+)\\s*$"),
    LOAD_GAME("^\\s*load\\s+game\\s*$"),
    EXIT_GAME("^\\s*exit\\s+game\\s*$"),
    NEXT_TURN("^\\s*next\\s+turn\\s*$"),
    TIME("^\\s*time\\s*$"),
    DATE("^\\s*date\\s*$"),
    DATETIME("^\\s*datetime\\s*$"),
    DAY_OF_THE_WEEK("^\\s*day\\s+of\\s+the\\s+week\\s*$"),
    SEASON("^\\s*season\\s*$"),
    WEATHER("^\\s*weather\\s*$"),
    WEATHER_FORECAST("^\\s*weather\\s+forecast\\s*$"),
    PRINT_MAP("^\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s+,\\s+(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    HELPREADINGMAP("^\\s*help\\s+reading\\s+map\\s*$"),
    WALK("^\\s*walk\\s+-l\\s+(?<x>\\d+)\\s+,\\s+(?<y>\\d+)\\s*$");

    private final String commandRegex;
    GameMenuCommands(String commandRegex){
        this.commandRegex = commandRegex;
    }

    public Matcher regexMatcher(String command){
        Pattern pattern = Pattern.compile(this.commandRegex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }
}
