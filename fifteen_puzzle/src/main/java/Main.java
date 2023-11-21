import interfaces.Game;
import v1.GameV1;
import v2.GameV2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        Game game = new GameV1();
        game.doGame();

    }
}
