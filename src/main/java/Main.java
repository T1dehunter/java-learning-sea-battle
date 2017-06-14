import core.*;
import gui.GuiBuilder;

import java.util.ArrayList;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {
        TestClasses test = new TestClasses();
        test.run();

        Properties props = new GameSettings("config/config.properties").getSettings();

        PlayerCreator creator = new PlayerCreator(props);

        ArrayList<Player> players = new ArrayList<>();

        players.add(creator.create("Player1"));
        players.add(creator.create("Player2"));

        int playerFieldSize = Integer.parseInt(props.getProperty("fieldSize"));

        GuiBuilder builder = new GuiBuilder(playerFieldSize);
        Core core = new Core(builder, players);
        builder.setCore(core);

        core.run();
    }
}
