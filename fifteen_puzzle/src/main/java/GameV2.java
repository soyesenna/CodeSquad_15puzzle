import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GameV2 implements Game{

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Puzzle puzzle = new PuzzleV2();

    @Override
    public void doGame() throws IOException {
        int turn = 1;
        while (puzzle.checkIsSorted()) {
            printTurnAndPuzzle(turn);
            int now = userInput().get(0);
            try {
                puzzle.change(now, 0);
                turn++;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        printTurnAndPuzzle(turn);
        System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
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
        StringBuilder sb = new StringBuilder();
        sb.append("Turn ");
        sb.append(turn);
        sb.append("\n");
        addPuzzleNums(sb);
        System.out.println(sb.toString());
    }

    @Override
    public void addPuzzleNums(StringBuilder sb) {
        List<List<Integer>> copiedPuzzle = null;
        if (puzzle instanceof PuzzleV2) copiedPuzzle = ((PuzzleV2) puzzle).getPuzzle();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append("[");
                int now = copiedPuzzle.get(i).get(j);
                if (now == 0) sb.append("  ");
                else if (now < 10) {
                    sb.append(" ");
                    sb.append(now);
                } else sb.append(now);
                sb.append("]");
            }
            sb.append("\n");
        }
    }
}
