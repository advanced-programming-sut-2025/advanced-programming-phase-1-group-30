package AP.group30.StardewValley.views;


import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {
    private Stage stage;
    private final Table table;
    private final Label titleLabel;
    private final TextButton startGameButton;
    private final TextButton profileButton;
    private final TextButton logoutButton;

    public MainMenu(Skin skin) {
        table = new Table(skin);
        titleLabel = new Label("Main Menu", skin);
        startGameButton = new TextButton("Start Game", skin);
        profileButton = new TextButton("Profile", skin);
        logoutButton = new TextButton("Logout", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);

        titleLabel.setColor(Color.BLACK);

        table.add(titleLabel);
        table.row().pad(15);
        table.add(startGameButton);
        table.row().pad(15);
        table.add(profileButton);
        table.row().pad(15);
        table.add(logoutButton);

        table.center();
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Main.batch.begin();
        Main.batch.draw(GameAssetManager.assetManager.get("menu assets/loading screen.png", Texture.class), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Main.batch.end();

        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new PreGameMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
            }
        });

        profileButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getMain().setScreen(new ProfileMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
            }
        });

        logoutButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                App.setCurrentUser(null);
                Main.getMain().setScreen(new LoginMenu(GameAssetManager.assetManager.get("skin/pixthulhu-ui.json", Skin.class)));
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
//    @Override
//    public void check(String command, Scanner scanner) {
//        Matcher matcher;
//
//        matcher = LoginMenuCommands.USER_LOGOUT.regexMatcher(command);
//        if (matcher.matches()) {
//            MainMenuController.logout();
//            return;
//        }
//        System.out.println("Invalid command");
//    }
}
