package AP.group30.StardewValley.views;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.controllers.NewGameController;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PreGameMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final Label numberOfPlayersLabel;
    private final SelectBox<String> numberOfPlayersBox;
    private final Label mapPlayer1Label;
    private final Label mapPlayer2Label;
    private final Label mapPlayer3Label;
    private final Label mapPlayer4Label;
    private final SelectBox<String> mapPlayer1Box;
    private final SelectBox<String> mapPlayer2Box;
    private final SelectBox<String> mapPlayer3Box;
    private final SelectBox<String> mapPlayer4Box;
    private final TextField username1Field;
    private final TextField username2Field;
    private final TextField username3Field;
    private final TextButton searchButton;
    private static Label errorLabel;
    private Texture background;

    public PreGameMenu(Skin skin) {
        table = new Table(skin);
        titleLabel = new Label("PreGame Menu", skin);
        numberOfPlayersLabel = new Label("Number Of Players", skin);
        numberOfPlayersBox = new SelectBox<>(skin);
        numberOfPlayersBox.setItems("2", "3", "4");
        mapPlayer1Label = new Label("Your Map ->", skin);
        mapPlayer2Label = new Label("Player1 Map ->", skin);
        mapPlayer3Label = new Label("Player2 Map ->", skin);
        mapPlayer4Label = new Label("Player3 Map ->", skin);
        mapPlayer1Box = new SelectBox<>(skin);
        mapPlayer1Box.setItems("1", "2", "3", "4");
        mapPlayer2Box = new SelectBox<>(skin);
        mapPlayer2Box.setItems("1", "2", "3", "4");
        mapPlayer3Box = new SelectBox<>(skin);
        mapPlayer3Box.setItems("1", "2", "3", "4");
        mapPlayer4Box = new SelectBox<>(skin);
        mapPlayer4Box.setItems("1", "2", "3", "4");
        username1Field = new TextField("username 1", skin);
        username2Field = new TextField("username 2", skin);
        username3Field = new TextField("username 3", skin);
        searchButton = new TextButton("Search Players", skin);
        errorLabel = new Label("", skin);
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

        username2Field.setVisible(false);
        username3Field.setVisible(false);
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
        table.add(numberOfPlayersBox).width(100);
        table.row().pad(15);
        table.add(mapPlayer1Label).width(200);
        table.add(mapPlayer1Box).width(100);
        table.row().pad(15);
        table.add(username1Field).width(300);
        table.add(mapPlayer2Label).width(200);
        table.add(mapPlayer2Box).width(100);
        table.row().pad(15);
        table.add(username2Field).width(300);
        table.add(mapPlayer3Label).width(200);
        table.add(mapPlayer3Box).width(100);
        table.row().pad(15);
        table.add(username3Field).width(300);
        table.add(mapPlayer4Label).width(200);
        table.add(mapPlayer4Box).width(100);
        table.row().pad(15);
        table.add(searchButton);
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

        numberOfPlayersBox.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                if (numberOfPlayersBox.getSelected().equals("2")) {
                    username1Field.setVisible(true);
                    username2Field.setVisible(false);
                    username3Field.setVisible(false);
                    mapPlayer2Box.setVisible(true);
                    mapPlayer3Box.setVisible(false);
                    mapPlayer4Box.setVisible(false);
                    mapPlayer2Label.setVisible(true);
                    mapPlayer3Label.setVisible(false);
                    mapPlayer4Label.setVisible(false);
                } else if (numberOfPlayersBox.getSelected().equals("3")) {
                    username1Field.setVisible(true);
                    username2Field.setVisible(true);
                    username3Field.setVisible(false);
                    mapPlayer2Box.setVisible(true);
                    mapPlayer3Box.setVisible(true);
                    mapPlayer4Box.setVisible(false);
                    mapPlayer2Label.setVisible(true);
                    mapPlayer3Label.setVisible(true);
                    mapPlayer4Label.setVisible(false);
                } else if (numberOfPlayersBox.getSelected().equals("4")) {
                    username1Field.setVisible(true);
                    username2Field.setVisible(true);
                    username3Field.setVisible(true);
                    mapPlayer2Box.setVisible(true);
                    mapPlayer3Box.setVisible(true);
                    mapPlayer4Box.setVisible(true);
                    mapPlayer2Label.setVisible(true);
                    mapPlayer3Label.setVisible(true);
                    mapPlayer4Label.setVisible(true);
                }
            }
        });

        username1Field.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    username1Field.setText("");
                    cleared = true;
                }
            }
        });

        username1Field.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && username1Field.getText().isEmpty()) {
                    username1Field.setText("username 1");
                }
            }
        });

        username2Field.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    username2Field.setText("");
                    cleared = true;
                }
            }
        });

        username2Field.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && username2Field.getText().isEmpty()) {
                    username2Field.setText("username 2");
                }
            }
        });

        username3Field.addListener(new ClickListener() {
            boolean cleared = false;

            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    username3Field.setText("");
                    cleared = true;
                }
            }
        });

        username3Field.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && username3Field.getText().isEmpty()) {
                    username3Field.setText("username 3");
                }
            }
        });

        searchButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                boolean result = NewGameController.NewGame(Integer.parseInt(numberOfPlayersBox.getSelected()),
                    username1Field.getText(), username2Field.getText(),
                    username3Field.getText(), Integer.parseInt(mapPlayer1Box.getSelected()),
                    Integer.parseInt(mapPlayer2Box.getSelected()), Integer.parseInt(mapPlayer3Box.getSelected()),
                    Integer.parseInt(mapPlayer4Box.getSelected()));

                if (result) {
                    Main.getMain().setScreen(new GameScreen());
                }
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
