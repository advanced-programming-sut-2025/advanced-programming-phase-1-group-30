package models.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands {
    GAME_NEW("^\\s*game\\s+new\\s*(-u\\s+(?<username1>\\S+))?(\\s+(?<username2>\\S+))?(\\s+(?<username3>\\S+))?\\s*$"),
    GAME_MAP("^\\s*game\\s+map\\s+(?<mapNumber>\\d+)\\s+-g(?<gender>.+)\\s*$"),
    LOAD_GAME("^\\s*load\\s+game\\s*$"),
    EXIT_GAME("^\\s*exit\\s+game\\s*$"),
    NEXT_TURN("^\\s*next\\s+turn\\s*$"),
    TIME("^\\s*time\\s*$"),
    CHEAT_TIME("^\\s*cheat\\s+advance\\s+time\\s+(?<X>\\d+)\\s*h\\s*$"),
    CHEAT_DATE("^\\s*cheat\\s+advance\\s+date\\s+(?<X>\\d+)\\s*d\\s*$"),
    DATE("^\\s*date\\s*$"),
    DATETIME("^\\s*datetime\\s*$"),
    DAY_OF_THE_WEEK("^\\s*day\\s+of\\s+the\\s+week\\s*$"),
    SEASON("^\\s*season\\s*$"),
    WEATHER("^\\s*weather\\s*$"),
    WEATHER_FORECAST("^\\s*weather\\s+forecast\\s*$"),
    PRINT_MAP("^\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    HELPREADINGMAP("^\\s*help\\s+reading\\s+map\\s*$"),
    ENERGY_SHOW("^\\s*energy\\s+show\\s*$"),
    ENERGY_SET("^\\s*energy\\s+set\\s+-v\\s+(?<value>.*\\S)\\s*$"),
    ENERGY_UNLIMITED("^\\s*energy\\s+unlimited\\s*$"),
    WALK("^\\s*walk\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    INVENTORY_SHOW("^\\s*inventory\\s+show\\s*$"),
    INVENTORY_TRASH("^\\s*inventory\\s+trash\\s+-i\\s+(?<itemName>.*\\S)(\\s+-n\\s+(?<number>.*\\S))?\\s*$"),
    EQUIP_TOOL("^\\s*tools\\s+equip\\s+(?<name>.*)\\s*$"),
    CURRENT_TOOL("^\\s*tools\\s+show\\s+current\\s*"),
    Tool_Use("^\\s*tools\\s+use\\s+-d\\s+(?<direction>.*)\\s*$"),
    AVAILABLE_TOOLS("^\\s*tools\\s+show\\s+available\\s*$"),
    SHOW_PLANT("^\\s*showplant\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    CRAFT_INFO("^\\s*craftinfo\\s+-n\\s+(?<craftName>.*\\S)\\s*$"),
    PLANT("^\\s*plant\\s+-s\\s+(?<seed>.*\\S)\\s+-d\\s+(?<direction>.*\\S)\\s*$"),
    SHOWPLANT("^\\s*showplant\\s+-l\\s+(?<location>.*\\S)\\s*$"),
    FERTILIZE("^\\s*fertilize\\s+-f\\s+(?<fertilizer>.*\\S)\\s+-d\\s+(?<direction>.*\\S)\\s*$"),
    HOWMUCH_WATER("^\\s*howmuch\\s+water\\s*$"),
    CRAFTING_SHOW_RECIPES("^\\s*crafting\\s+show\\s+recipes\\s*$"),
    CRAFTING_CRAFT("^\\s*crafting\\s+craft\\s+(?<itemName>.*\\S)\\s*$"),
    PLACE_ITEM("^\\s*place\\s+item\\s+-n\\s+(?<itemName>.*\\S)\\s+-d\\s+(?<direction>.*\\S)\\s*$"),
    CHEAT_ADD_ITEM("^\\s*cheat\\s+add\\s+item\\s+-n\\s+(?<itemName>.*\\S)\\s+-c\\s+(?<count>.*\\S)\\s*$"),
    COOKING_REFRIGERATOR("^\\s*cooking\\s+refrigerator\\s+(?<action>put|pick)\\s+(?<item>.*\\S)\\s*$"),
    COOKING_SHOW_RECIPES("^\\s*cooking\\s+show\\s+recipes(\\s+(?<all>-a))\\s*$"),
    COOKING_ADD_RECIPE("^\\s*cooking\\s+add\\s+recipe\\s+-n\\s+(?<name>.*\\S)\\s*$"),
    COOKING_PREPARE("^\\s*cooking\\s+prepare\\s+(?<recipeName>.*\\S)\\s*$"),
    EAT("^\\s*eat\\s+(?<foodName>.*\\S)\\s*$"),
    BUILD("^\\s*build\\s+-a\\s+(?<buildingName>.*\\S)\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    BUY_ANIMAL("^\\s*buy\\s+animal\\s+-a\\s+(?<animal>.*\\S)\\s+-n\\s+(?<name>.*\\S)\\s*$"),
    PET("^\\s*pet\\s+-n\\s+(?<name>.*\\S)\\s*$"),
    CHEAT_SET_FRIENDSHIP("^\\s*cheat\\s+set\\s+friendship\\s+-n\\s+(?<animalName>.*\\S)\\s+-c\\s+(?<amount>.*\\S)\\s*$"),
    ANIMALS("^\\s*animals\\s*$"),
    SHEPHERD_ANIMALS("^\\s*shepherd\\s+animals\\s+-n\\s+(?<animalName>.*\\S)\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    FEED_HAY("^\\s*feed\\s+hay\\s+-n\\s+(?<animalName>.*\\S)\\s*$"),
    PRODUCES("^\\s*produces\\s*$"),
    COLLECT_PRODUCE("^\\s*collect\\s+produce\\s+-n\\s+(?<name>.*\\S)\\s*$"),
    SELL_ANIMAL("^\\s*sell\\s+animal\\s+-n\\s+(?<name>.*\\S)\\s*$"),
    FISHING("^\\s*fishing\\s+-p\\s+(?<fishingPole>.*\\S)\\s*$"),
    ARTISAN_USE("^\\s*artisan\\s+use\\s+(?<artisanName>.*\\S)\\s+(?<itemName>.*\\S)\\s*$"),
    ARTISAN_GET("^\\s*artisan\\s+get\\s+(?<artisanName>.*\\S)\\s*$"),
    SHOW_ALL_PRODUCTS("^\\s*show\\s+all\\s+products\\s*$"),
    SHOW_ALL_AVAILABLE_PRODUCTS("^\\s*show\\s+all\\s+available\\s+products\\s*$"),
    PURCHASE("^\\s*purchase\\s+(?<productName>.*\\S)\\s+-n\\s+(?<count>\\d+)\\s*$"),
    CHEAT_ADD_DOLLARS("^\\s*cheat\\s+add\\s+(?<count>\\d+)\\s+dollars\\s*$"),
    SELL("^\\s*sell\\s+(?<productName>.*\\S)\\s+-n\\s+(?<count>\\d+)\\s*$"),
    FRIENDSHIPS("^\\s*friendships\\s*$"),
    TALK("^\\s*talk\\s+-u\\s+(?<username>.*\\S)\\s+-m\\s+(?<message>.*\\S)\\s*$"),
    TALK_HISTORY("^\\s*talk\\s+history\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    GIFT("^\\s*gift\\s+-u\\s+(?<username>.*\\S)\\s+-i\\s+(?<item>.*\\S)\\s+-a\\s+(?<amount>.*\\S)\\s*$"),
    GIFT_LIST("^\\s*gift\\s+list\\s*$"),
    GIFT_RATE("^\\s*gift\\s+rate\\s+-i\\s+(?<giftNumber>.*\\S)\\s+-r\\s+(?<rate>.*\\S)\\s*$"),
    GIFT_HISTORY("^\\s*gift\\s+history\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    HUG("^\\s*hug\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    FLOWER("^\\s*flower\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    ASK_MARRIAGE("^\\s*ask\\s+marriage\\s+-u\\s+(?<username>.*\\S)\\s+-r\\s+(?<ring>.*\\S)\\s*$"),
    RESPOND("^\\s*respond\\s+(?<answer>(-accept|-reject))\\s+-u\\s+(?<username>.*\\S)\\s*$"),
    START_TRADE("^\\s*start\\s+trade\\s*$"),
    TRADE("^\\s*trade\\s+-u\\s+(?<username>.*\\S)\\s+-t\\s+(?<type>.*\\S)\\s+-i\\s+(?<item>.*\\S)\\s+-a\\s+(?<amount>.*\\S)(\\s+-p\\s+(?<price>.*\\S))?(\\s*-ti\\s+(?<targetItem>.*\\S)\\s+-ta\\s+(?<targetAmount>.*\\S))?\\s*$"),
    TRADE_LIST("^\\s*trade\\s+list\\s*$"),
    TRADE_RESPONSE("^\\s*trade\\s+response\\s+(?<answer>(-accept|-reject))\\s+-i\\s+(?<id>.*\\S)\\s*$"),
    TRADE_HISTORY("^\\s*trade\\s+history\\s*$"),
    MEET_NPC("^\\s*meet\\s+NPC\\s+(?<npcName>.*\\S)\\s*$"),
    GIFT_NPC("^\\s*gift\\s+NPC\\s+(?<npcName>.*\\S)\\s+-i\\s+(?<item>.*\\S)\\s*$"),
    FRIENDSHIP_NPC_LIST("^\\s*friendship\\s+NPC\\s+list\\s*$"),
    QUESTS_LIST("^\\s*quests\\s+list\\s*$"),
    QUESTS_FINISH("^\\s*quests\\s+finish\\s+-i\\s+(?<index>.*\\S)\\s*$"),
    PRINT_CITY_MAP("^\\s*print\\s+city\\s+map\\s*$"),
    PRINT_FULL_MAP("^\\s*print\\s+full\\s+map\\s*$"),
    GoToCity("^\\s*go\\s+to\\s+city\\s*$"),
    GoToFarm("^\\s*go\\s+to\\s+farm\\s*$"),;



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
