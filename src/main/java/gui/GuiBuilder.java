package gui;

import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuiBuilder implements PlayerActionHandler {
    private Core core;

    private int playerGameFieldWidth;
    private int playerGameFieldHeight;

    private Map<String, GameScreen> playersScreens = new HashMap<>();

    public GuiBuilder(int gameFieldWidth, int gameFieldHeight) {
        this.playerGameFieldWidth = gameFieldWidth;
        this.playerGameFieldHeight = gameFieldHeight;
    }

    public void build(GameDTO gameData) {
        for (PlayerDTO playerData: gameData.getPlayersData()) {
            GameScreen screen;

            PlayerAction action = new PlayerAction(playerData.getName());

            screen = new GameScreen(playerGameFieldWidth, playerGameFieldHeight, playerData,this, action);
            screen.build(playerData.getMessage());

            playersScreens.put(playerData.getName(), screen);
        }
    }

    public void handle(PlayerAction action) {
        core.handlePlayerAction(action);
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public void update(GameDTO gameData) {
        System.out.print("game dto");
        for (PlayerDTO playerData: gameData.getPlayersData()) {
            GameScreen screen = playersScreens.get(playerData.getName());

            screen.update(playerData);
        }
    }
}
