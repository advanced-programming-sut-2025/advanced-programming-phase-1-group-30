package models.Commands;

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
    ENERGY_SHOW("^\\s*energy\\s+show\\s*$"),
    ENERGY_SET("^\\s*energy\\s+set\\s+-v\\s+(?<value>.*\\S)\\s*$"),
    ENERGY_UNLIMITED("^\\s*energy\\s+unlimited\\s*$"),
    WALK("^\\s*walk\\s+-l\\s+(?<x>\\d+)\\s+,\\s+(?<y>\\d+)\\s*$"),
    INVENTORY_SHOW("^\\s*inventory\\s+show\\s*$"),
    INVENTORY_TRASH("^\\s*inventory\\s+trash\\s+-i\\s+(?<itemName>.*\\S)(\\s+-n\\s+(?<number>.*\\S))?\\s*$"),
    EQUIP_TOOL("^\\s*tools\\s+equip\\s+(?<name>.*)\\s*$"),
    CURRENT_TOOL("^\\s*tools\\s+show\\s+current\\s*"),
    Tool_Use("^\\s*tools\\s+use\\s+-d\\s+(?<direction>.*)\\s*$"),
    AVAILABLE_TOOLS("^\\s*tools\\s+show\\s+available\\s*$"),
    PLANT("^\\s*plant\\s+-s\\s+(?<seed>.+\\S)\\s+-d\\s+(?<direction>.*\\S)\\s*"),
    SHOW_PLANT("^\\s*showplant\\s+-l\\s+(?<x>\\d+)\\s+,\\s+(?<y>\\d+)\\s*$");

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
