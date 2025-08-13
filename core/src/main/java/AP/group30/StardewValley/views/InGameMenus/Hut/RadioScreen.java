package AP.group30.StardewValley.views.InGameMenus.Hut;

import AP.group30.StardewValley.Main;
import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.network.MessageClasses.LeaderBoardUpdate;
import AP.group30.StardewValley.network.MessageClasses.Radio;
import AP.group30.StardewValley.views.InGameMenus.InGameMenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RadioScreen extends InGameMenuScreen {

    private HashMap<String, String> otherPlayers = new HashMap<>();
    private Array<String> allMusicFiles = new Array<>(new String[]{
        "Music/Bezan_Baran.mp3",
        "Music/Bi_Ehsas.mp3",
        "Music/Change_Del.mp3",
        "Music/Dokhtare_Khaan.mp3",
        "Music/Harighe_Sabz.mp3",
        "Music/Loknat.mp3",
        "Music/Naneh.mp3",
        "Music/Tannaz.mp3",
        "Music/Zelzeleh.mp3"
    });

    private Array<Music> currentTracks = new Array<>();
    private Music playingMusic = null;

    public RadioScreen(SpriteBatch batch, Skin skin) {
        super(batch, skin, GameAssetManager.skill, 1, 0, 200);
        stage.addActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
        backgroundTexture.dispose();
        for (Music music : currentTracks) {
            music.dispose();
        }
    }

    @Override
    protected void refresh() {
        ArrayList<String> usernames = new ArrayList<>();
        for (Player player : App.getCurrentGame().getPlayers()) {
            usernames.add(player.getUsername());
        }
        for (String name : usernames) {
            if (!name.equals(App.getCurrentGame().getCurrentPlayer().getUsername())) {
                Radio r = new Radio();
                r.send = true;
                r.senderUsername = App.getCurrentUser().getUsername();
                r.receiverUsername = name;
                Main.getMain().client.send(r);
            }
        }

        table.clear();

        for (Music music : currentTracks) {
            music.dispose();
        }
        currentTracks.clear();

        int count = MathUtils.random(1, 4);

        Array<String> shuffled = new Array<>(allMusicFiles);
        shuffled.shuffle();
        Array<String> selected = new Array<>();
        for (int i = 0; i < count; i++) {
            selected.add(shuffled.get(i));
        }

        for (String path : selected) {
            Music music = Gdx.audio.newMusic(Gdx.files.internal(path));
            currentTracks.add(music);

            Pattern pattern = Pattern.compile("^Music(?<name>.*).mp3$");
            Matcher matcher = pattern.matcher(path);
            String musicName = matcher.find() ? matcher.group("name") : path;
            Label nameLabel = new Label(musicName, skin);

            TextButton playButton = new TextButton("Play", skin);
            TextButton stopButton = new TextButton("Stop", skin);

            playButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (playingMusic != null && playingMusic.isPlaying()) {
                        playingMusic.stop();
                    }
                    playingMusic = music;
                    music.play();
                    App.setCurrentRadio(path);
                }
            });

            stopButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (music.isPlaying()) {
                        music.stop();
                        App.setCurrentRadio(null);
                    }
                }
            });

            table.add(nameLabel).pad(20);
            table.add(playButton).pad(5);
            table.add(stopButton).pad(5);
            table.row();
        }

        table.row();
        otherPlayers = App.getOtherPlayersRadio();
        for (String name : otherPlayers.keySet()) {
            if (otherPlayers.get(name) == null) {
                Label nameLabel = new Label(name + "'s Radio :      Turned Off", skin);

                table.add(nameLabel);
                table.row();
            }
            else {
                Music music = Gdx.audio.newMusic(Gdx.files.internal(otherPlayers.get(name)));
                currentTracks.add(music);

                Label nameLabel = new Label(name + "'s Radio", skin);

                TextButton playButton = new TextButton("Play", skin);
                TextButton stopButton = new TextButton("Stop", skin);

                playButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (playingMusic != null && playingMusic.isPlaying()) {
                            playingMusic.stop();
                        }
                        playingMusic = music;
                        music.play();
                        App.setCurrentRadio(otherPlayers.get(name));
                    }
                });

                stopButton.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (music.isPlaying()) {
                            music.stop();
                            App.setCurrentRadio(null);
                        }
                    }
                });

                table.add(nameLabel).pad(20);
                table.add(playButton).pad(5);
                table.add(stopButton).pad(5);
                table.row();
            }
        }
    }

    @Override
    public void hide() {
        super.hide();
        for (Music music : currentTracks) {
            if (music.isPlaying()) music.stop();
            music.dispose();
        }
    }
}

