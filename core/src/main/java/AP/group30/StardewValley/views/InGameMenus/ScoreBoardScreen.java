package AP.group30.StardewValley.views.InGameMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.Players.PlayerLeaderboard;
import AP.group30.StardewValley.network.MessageClasses.LeaderBoardUpdate;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Timer;

import java.util.Comparator;

public class ScoreBoardScreen extends InGameMenuScreen {
    private ArrayList<PlayerLeaderboard> playerLeaderboards = new ArrayList<>();
    private String currentSortKey = "money";
    private boolean ascending = false;

    public ScoreBoardScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.skill, 1, 0, 300);
        stage.addActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
    }

    @Override
    protected void refresh() {
        updateLeaderBoard();

        table.clear();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                buildScoreTable();
            }
        }, 1.0f);
    }

    private void updateLeaderBoard() {
        ArrayList<String> usernames = new ArrayList<>();
        for (Player player : App.getCurrentGame().getPlayers()) {
            usernames.add(player.getUsername());
        }

        for (String name : usernames) {
            if (!name.equals(App.getCurrentGame().getCurrentPlayer().getUsername())) {
                LeaderBoardUpdate lBUpdate = new LeaderBoardUpdate();
                lBUpdate.send = true;
                lBUpdate.senderUsername = App.getCurrentUser().getUsername();
                lBUpdate.receiverUsername = name;
                Main.getMain().client.send(lBUpdate);
            }
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        PlayerLeaderboard playerLeaderboard = new PlayerLeaderboard(player.getUsername(), player.getMoney(),
            player.getFarming(), player.getForaging(), player.getFishing(), player.getMining(),
            player.getActivatedQuestNPC().size());
        App.addPlayerLeaderboard(playerLeaderboard);
        playerLeaderboards = App.getPlayerLeaderboards();
    }

    private void buildScoreTable() {
        // Header row
        addHeader("Username", "username");
        addHeader("Money", "money");
        addHeader("Farming", "farming");
        addHeader("Foraging", "foraging");
        addHeader("Fishing", "fishing");
        addHeader("Mining", "mining");
        addHeader("Quests", "quests");

        table.row();

        // Sort before adding rows
        sortLeaderboard();

        // Data rows
        for (PlayerLeaderboard p : playerLeaderboards) {
            table.add(new Label(p.getUsername(), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getMoney()), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getFarming()), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getForaging()), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getFishing()), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getMining()), skin)).pad(5);
            table.add(new Label(String.valueOf(p.getNumberOfQuests()), skin)).pad(5);
            table.row();
        }
    }

    private void addHeader(String text, String sortKey) {
        Label header = new Label(text, skin);
        header.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (currentSortKey.equals(sortKey)) {
                    ascending = !ascending;
                } else {
                    currentSortKey = sortKey;
                    ascending = false;
                }
                table.clear();
                buildScoreTable();
            }
        });
        table.add(header).pad(5);
    }

    private void sortLeaderboard() {
        Comparator<PlayerLeaderboard> comparator;
        switch (currentSortKey) {
            case "username":
                comparator = Comparator.comparing(PlayerLeaderboard::getUsername, String.CASE_INSENSITIVE_ORDER);
                break;
            case "money":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getMoney);
                break;
            case "farming":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getFarming);
                break;
            case "foraging":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getForaging);
                break;
            case "fishing":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getFishing);
                break;
            case "mining":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getMining);
                break;
            case "quests":
                comparator = Comparator.comparingInt(PlayerLeaderboard::getNumberOfQuests);
                break;
            default:
                comparator = Comparator.comparingInt(PlayerLeaderboard::getMoney);
        }
        if (!ascending) {
            comparator = comparator.reversed();
        }
        playerLeaderboards.sort(comparator);
    }
}

