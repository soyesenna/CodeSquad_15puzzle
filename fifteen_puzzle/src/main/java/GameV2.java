import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GameV2 implements Game{

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Puzzle puzzle = new PuzzleV2();

    @Override
    public void doGame() throws IOException {

    }

    @Override
    public List<Integer> userInput() throws IOException, NumberFormatException {
        boolean correctInput = false;
        String input;
        int result = 0;
        while (!correctInput) {
            System.out.print("숫자 입력> ");
            input = br.readLine();
            try {
                result = checkCorrectInput(input);
                correctInput = true;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\n잘못 입력하셨습니다. 다시 입력해 주세요.\n");
            }
        }
        return new ArrayList<>(List.of(result));
    }

    private int checkCorrectInput(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
            if (num < 1 || num > 15) throw new NumberFormatException();
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException();
        }
        return num;
    }

    @Override
    public void printTurnAndPuzzle(int turn) {

    }

    @Override
    public void addPuzzleNums(StringBuilder sb) {

    }
}
