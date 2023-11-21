import java.util.List;

public interface Game {

    void doGame();

    List<Integer> userInput();

    void printTurnAndPuzzle(int turn);

    void addPuzzleNums(StringBuilder sb);
}
