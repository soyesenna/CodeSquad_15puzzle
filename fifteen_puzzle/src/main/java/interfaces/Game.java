package interfaces;

import java.io.IOException;
import java.util.List;

public interface Game {

    void doGame() throws IOException;

    List<Integer> userInput() throws IOException, NumberFormatException;

    void printTurnAndPuzzle(int turn);

    void addPuzzleNums(StringBuilder sb);
}
