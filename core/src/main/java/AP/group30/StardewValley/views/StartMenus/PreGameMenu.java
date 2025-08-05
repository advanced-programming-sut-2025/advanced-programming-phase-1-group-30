package AP.group30.StardewValley.views.StartMenus;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.NewGameController;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Lobby;
import AP.group30.StardewValley.models.Users.User;
import AP.group30.StardewValley.views.CityScreen;
import AP.group30.StardewValley.views.GameScreen;
import AP.group30.StardewValley.views.LoadingScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PreGameMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final Label numberOfPlayersLabel;
    private final Label mapPlayer1Label;
    private Label mapPlayer2Label;
    private Label mapPlayer3Label;
    private Label mapPlayer4Label;
    private final SelectBox<String> mapPlayer1Box;
    private final SelectBox<String> mapPlayer2Box;
    private final SelectBox<String> mapPlayer3Box;
    private final SelectBox<String> mapPlayer4Box;
    private final TextButton searchButton;
    private final TextButton backButton;
    private static Label errorLabel;
    private Texture background;

    private final Lobby lobby;

    public PreGameMenu(Skin skin, Lobby theLobby) {
        table = new Table(skin);
        titleLabel = new Label("PreGame Menu", skin);
        lobby = theLobby;
        numberOfPlayersLabel = new Label("Number Of Players: " + lobby.getUsers().size(), skin);
        mapPlayer1Label = new Label("Your Map :", skin);
        mapPlayer2Label = new Label("Player1 Map :", skin);
        mapPlayer3Label = new Label("Player2 Map :", skin);
        mapPlayer4Label = new Label("Player3 Map :", skin);
        mapPlayer1Box = new SelectBox<>(skin);
        mapPlayer1Box.setItems("1", "2", "3", "4");
        mapPlayer2Box = new SelectBox<>(skin);
        mapPlayer2Box.setItems("1", "2", "3", "4");
        mapPlayer3Box = new SelectBox<>(skin);
        mapPlayer3Box.setItems("1", "2", "3", "4");
        mapPlayer4Box = new SelectBox<>(skin);
        mapPlayer4Box.setItems("1", "2", "3", "4");
        searchButton = new TextButton("Start", skin);
        backButton = new TextButton("Back", skin);
        errorLabel = new Label("", skin);

        if (lobby.getUsers().size() > 1)
            mapPlayer2Label = new Label(App.getCurrentLobby().getUsers().get(1).getUsername() + "'s Map :", skin);
        if (lobby.getUsers().size() > 2)
            mapPlayer3Label = new Label(App.getCurrentLobby().getUsers().get(2).getUsername() + "'s Map :", skin);
        if (lobby.getUsers().size() > 3)
            mapPlayer4Label = new Label(App.getCurrentLobby().getUsers().get(3).getUsername() + "'s Map :", skin);
    }

    public static void printResult(String message) {
        errorLabel.setVisible(true);
        errorLabel.setText(message);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        if (LoadingScreen.time.getHour() <= 11) {
            background = GameAssetManager.assetManager.get(GameAssetManager.background);
        } else {
            background = GameAssetManager.assetManager.get(GameAssetManager.nightBackground);
        }

        errorLabel.setColor(Color.RED);
        errorLabel.setVisible(false);

        mapPlayer3Box.setVisible(false);
        mapPlayer4Box.setVisible(false);
        mapPlayer3Label.setVisible(false);
        mapPlayer4Label.setVisible(false);

        titleLabel.setColor(Color.BLACK);
        numberOfPlayersLabel.setColor(Color.BLACK);
        mapPlayer1Label.setColor(Color.BLACK);
        mapPlayer2Label.setColor(Color.BLACK);
        mapPlayer3Label.setColor(Color.BLACK);
        mapPlayer4Label.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(numberOfPlayersLabel).width(200);
        table.row().pad(15);
        table.add(mapPlayer1Label).width(200);
        table.add(mapPlayer1Box).width(100);
        table.row().pad(15);
        table.add(mapPlayer2Label).width(200);
        table.add(mapPlayer2Box).width(100);
        table.row().pad(15);
        table.add(mapPlayer3Label).width(200);
        table.add(mapPlayer3Box).width(100);
        table.row().pad(15);
        table.add(mapPlayer4Label).width(200);
        table.add(mapPlayer4Box).width(100);
        table.row().pad(15);
        table.add(searchButton);
        table.row().pad(15);
        table.add(backButton);
        table.row().pad(15);
        table.add(errorLabel);

        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(background,
            0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        if (lobby.getUsers().size() == 2) {
            mapPlayer2Box.setVisible(true);
            mapPlayer3Box.setVisible(false);
            mapPlayer4Box.setVisible(false);
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(false);
            mapPlayer4Label.setVisible(false);
        } else if (lobby.getUsers().size() == 3) {
            mapPlayer2Box.setVisible(true);
            mapPlayer3Box.setVisible(true);
            mapPlayer4Box.setVisible(false);
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(true);
            mapPlayer4Label.setVisible(false);
        } else if (lobby.getUsers().size() == 4) {
            mapPlayer2Box.setVisible(true);
            mapPlayer3Box.setVisible(true);
            mapPlayer4Box.setVisible(true);
            mapPlayer2Label.setVisible(true);
            mapPlayer3Label.setVisible(true);
            mapPlayer4Label.setVisible(true);
        }

        searchButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User user1 = null;
                User user2 = null;
                User user3 = null;
                if (lobby.getUsers().size() > 1)
                    user1 = App.getCurrentLobby().getUsers().get(1);
                if (lobby.getUsers().size() > 2)
                    user2 = App.getCurrentLobby().getUsers().get(2);
                if (lobby.getUsers().size() > 3)
                    user3 = App.getCurrentLobby().getUsers().get(3);

                Game result = NewGameController.NewGame(lobby.getUsers().size(),
                    user1, user2, user3, Integer.parseInt(mapPlayer1Box.getSelected()),
                    Integer.parseInt(mapPlayer2Box.getSelected()), Integer.parseInt(mapPlayer3Box.getSelected()),
                    Integer.parseInt(mapPlayer4Box.getSelected()));
                RegisterMenu.gameScreen = new GameScreen(result);
                RegisterMenu.cityScreen = new CityScreen(result);
                Main.getMain().setScreen(new LoadingScreen(RegisterMenu.gameScreen));
            }
        });

        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.setCurrentLobby(null);
                Main.getMain().setScreen(new MainMenu(Main.getMain().skin));
            }
        });

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
