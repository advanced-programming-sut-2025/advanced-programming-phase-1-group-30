package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.models.SaveData.SaveGame;
import AP.group30.StardewValley.models.SaveData.SavePlayer;
import AP.group30.StardewValley.models.SaveData.SaveUser;
import AP.group30.StardewValley.models.Users.User;

import java.util.ArrayList;

public class SaveLoadController {
    public static SaveGame convertToSaveGame() {
        Game game = App.getCurrentGame();
        Player player = game.getCurrentPlayer();
        User user = player.getUser();

        SaveUser saveUser = convertUserForSave(user);
        SavePlayer savePlayer = ConvertPlayerForSave(player, saveUser);
        ArrayList<SavePlayer> players = convertPlayersForSave();
        SaveGame saveGame = convertGameForSave(game, savePlayer, players);

        return saveGame;
    }

    public static Game convertToLoadGame(SaveGame saveGame) {
        SaveUser loadUser = saveGame.getCurrentPlayer().getUser();
        User user = new User(loadUser.getUsername(), loadUser.getPassword(), loadUser.getNickname(), loadUser.getEmail(),
            loadUser.getQuestion(), loadUser.getAnswer(), loadUser.getGender());
        user.setMaxMoney(loadUser.getMaxMoney());
        user.setNumOfGames(loadUser.getNumOfGames());
        user.setPlayer(null);
        user.setInGame(loadUser.isInGame());

        SavePlayer loadPlayer = saveGame.getCurrentPlayer();
        Player player = new Player(user, loadPlayer.getUsername(), loadPlayer.getSelectionNumber(), loadPlayer.getGender(),
            loadPlayer.getMap());
        player.setId(loadPlayer.getId());
        player.setX(loadPlayer.getX());
        player.setY(loadPlayer.getY());
        player.setEnergy(loadPlayer.getEnergy());
        player.setShippingBin(loadPlayer.getShippingBin());
        player.setBackPack(loadPlayer.getBackPack());
        player.setTrashCan(loadPlayer.getTrashCan());
        player.setRefrigerator(loadPlayer.getRefrigerator());
        player.setMoney(loadPlayer.getMoney());
        player.setPassedOut(loadPlayer.isPassedOut());
        player.setWield(loadPlayer.getWield());
        player.setFarming(loadPlayer.getFarming());
        player.setForaging(loadPlayer.getForaging());
        player.setMining(loadPlayer.getMining());
        player.setFishing(loadPlayer.getFishing());
        player.setMaxEnergy(loadPlayer.getMaxEnergy());
        player.setProducts(loadPlayer.getProducts());
        player.setItemsBoughtToday(loadPlayer.getItemsBoughtToday());
        player.setCraftingRecipes(loadPlayer.getCraftingRecipes());
        player.setDevices(loadPlayer.getDevices());
        player.setRecipes(loadPlayer.getRecipes());
        player.setInCity(loadPlayer.isInCity());
        player.setLastEnergy(loadPlayer.getLastEnergy());
        player.setEnergyBuff(loadPlayer.isEnergyBuff());
        player.setLevelBuff(loadPlayer.isLevelBuff());
        player.setDirection(loadPlayer.getDirection());
        player.setArtisanItemsProsses(loadPlayer.getArtisanItemsProsses());
        player.setMoving(loadPlayer.isMoving());
        player.setFacingLeft(loadPlayer.isFacingLeft());
        player.setReactionTime(loadPlayer.getReactionTime());
        player.setStateTime(loadPlayer.getStateTime());
        player.setChat(loadPlayer.getChat());
        user.setPlayer(player);

        ArrayList<Player> players = new ArrayList<>();
        for (SavePlayer otherLoadPlayer : saveGame.getPlayers()) {
            SaveUser loadOtherUser = otherLoadPlayer.getUser();
            User otherUser = new User(loadOtherUser.getUsername(), loadOtherUser.getPassword(),
                loadOtherUser.getNickname(), loadOtherUser.getEmail(), loadOtherUser.getQuestion(),
                loadOtherUser.getAnswer(), loadOtherUser.getGender());
            otherUser.setMaxMoney(loadOtherUser.getMaxMoney());
            otherUser.setNumOfGames(loadOtherUser.getNumOfGames());
            otherUser.setPlayer(null);
            otherUser.setInGame(loadOtherUser.isInGame());

            Player otherPlayer = new Player(otherUser, otherLoadPlayer.getUsername(), otherLoadPlayer.getSelectionNumber(),
                otherLoadPlayer.getGender(), otherLoadPlayer.getMap());
            otherPlayer.setId(otherLoadPlayer.getId());
            otherPlayer.setX(otherLoadPlayer.getX());
            otherPlayer.setY(otherLoadPlayer.getY());
            otherPlayer.setEnergy(otherLoadPlayer.getEnergy());
            otherPlayer.setShippingBin(otherLoadPlayer.getShippingBin());
            otherPlayer.setBackPack(otherLoadPlayer.getBackPack());
            otherPlayer.setTrashCan(otherLoadPlayer.getTrashCan());
            otherPlayer.setRefrigerator(otherLoadPlayer.getRefrigerator());
            otherPlayer.setMoney(otherLoadPlayer.getMoney());
            otherPlayer.setPassedOut(otherLoadPlayer.isPassedOut());
            otherPlayer.setWield(otherLoadPlayer.getWield());
            otherPlayer.setFarming(otherLoadPlayer.getFarming());
            otherPlayer.setForaging(otherLoadPlayer.getForaging());
            otherPlayer.setMining(otherLoadPlayer.getMining());
            otherPlayer.setFishing(otherLoadPlayer.getFishing());
            otherPlayer.setMaxEnergy(otherLoadPlayer.getMaxEnergy());
            otherPlayer.setProducts(otherLoadPlayer.getProducts());
            otherPlayer.setItemsBoughtToday(otherLoadPlayer.getItemsBoughtToday());
            otherPlayer.setCraftingRecipes(otherLoadPlayer.getCraftingRecipes());
            otherPlayer.setDevices(otherLoadPlayer.getDevices());
            otherPlayer.setRecipes(otherLoadPlayer.getRecipes());
            otherPlayer.setInCity(otherLoadPlayer.isInCity());
            otherPlayer.setLastEnergy(otherLoadPlayer.getLastEnergy());
            otherPlayer.setEnergyBuff(otherLoadPlayer.isEnergyBuff());
            otherPlayer.setLevelBuff(otherLoadPlayer.isLevelBuff());
            otherPlayer.setDirection(otherLoadPlayer.getDirection());
            otherPlayer.setArtisanItemsProsses(otherLoadPlayer.getArtisanItemsProsses());
            otherPlayer.setMoving(otherLoadPlayer.isMoving());
            otherPlayer.setFacingLeft(otherLoadPlayer.isFacingLeft());
            otherPlayer.setReactionTime(otherLoadPlayer.getReactionTime());
            otherPlayer.setStateTime(otherLoadPlayer.getStateTime());
            otherPlayer.setChat(loadPlayer.getChat());
            otherUser.setPlayer(otherPlayer);

            players.add(otherPlayer);
        }

        Game game = new Game();
        game.setId(saveGame.getId());
        game.setCurrentPlayer(player);
        game.setCurrentMap(saveGame.getCurrentMap());
        game.setCurrentWeather(saveGame.getCurrentWeather());
        game.setCurrentTime(saveGame.getCurrentTime());
        game.setTomorrowWeather(saveGame.getTomorrowWeather());
        game.setPlayers(players);

        return game;
    }

    private static SaveGame convertGameForSave(Game game, SavePlayer savePlayer, ArrayList<SavePlayer> players) {
        SaveGame saveGame = new SaveGame(game.getId(), game.getCurrentTime(), savePlayer, game.getCurrentWeather(),
            game.getTomorrowWeather(), players, game.getCurrentMap());
        return saveGame;
    }

    private static ArrayList<SavePlayer> convertPlayersForSave() {
        ArrayList<SavePlayer> players = new ArrayList<>();
        for (Player otherPlayer : App.getCurrentGame().getPlayers()) {
            User otherUser = otherPlayer.getUser();

            SaveUser saveOtherUser = convertUserForSave(otherUser);

            SavePlayer saveOtherPlayer = ConvertPlayerForSave(otherPlayer, saveOtherUser);

            players.add(saveOtherPlayer);
        }
        return players;
    }

    private static SavePlayer ConvertPlayerForSave(Player player, SaveUser saveUser) {
        SavePlayer savePlayer = new SavePlayer(
            player.isFacingLeft(),
            player.getId(),
            player.getX(),
            player.getY(),
            player.getUsername(),
            player.getMap(),
            player.getEnergy(),
            player.getShippingBin(),
            player.getBackPack(),
            player.getTrashCan(),
            player.getRefrigerator(),
            player.getMoney(),
            player.getSelectionNumber(),
            player.isPassedOut(),
            player.getWield(),
            player.getFarming(),
            player.getForaging(),
            player.getFishing(),
            player.getMining(),
            player.getMaxEnergy(),
            player.getProducts(),
            player.getItemsBoughtToday(),
            player.getCraftingRecipes(),
            player.getDevices(),
            player.getRecipes(),
            player.getGender(),
            player.isInCity(),
            player.getLastEnergy(),
            player.isEnergyBuff(),
            player.isLevelBuff(),
            saveUser,
            player.getDirection(),
            player.getArtisanItemsProsses(),
            player.isMoving(),
            player.getStateTime(),
            player.getReactionTime(),
            player.getChat()
        );
        return savePlayer;
    }

    private static SaveUser convertUserForSave(User user) {
        SaveUser saveUser = new SaveUser(user.getGender(), user.getQuestion(), user.getAnswer(), user.getUsername(),
            user.getPassword(), user.getNickname(), user.getEmail(), user.getMaxMoney(), user.getNumOfGames(), null
            , user.isInGame());
        return saveUser;
    }
}
