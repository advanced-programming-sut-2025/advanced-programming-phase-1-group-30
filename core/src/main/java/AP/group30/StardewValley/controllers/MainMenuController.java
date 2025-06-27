package AP.group30.StardewValley.controllers;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.views.RegisterMenu;

public class MainMenuController {
    public static void logout() {
        App.setCurrentUser(null);
        RegisterMenu.printResult("User logged out successfully");
    }
}
