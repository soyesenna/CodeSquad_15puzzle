import javax.swing.*;
import java.io.*;
import java.util.*;

public class Game {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Puzzle puzzle = new Puzzle();

    public Game() {
    }

    public void doGame() throws IOException, NumberFormatException{
        int turn = 1;
        while (!puzzle.checkIsSorted()) {
            printTurnAndPuzzle(turn);
            List<Integer> input = userInput();
            puzzle.change(input.get(0), input.get(1));
            turn++;
        }
        printTurnAndPuzzle(turn);
        System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
    }

    private void printTurnAndPuzzle(int turn) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTurn ");
        sb.append(turn);
        sb.append("\n");
        addPuzzleNums(sb);
        System.out.println(sb.toString());
    }

    private void addPuzzleNums(StringBuilder sb) {
        sb.append("[");
        for (Integer num : puzzle.getPuzzle()) {
            sb.append(num);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
    }

    private List<Integer> userInput() throws IOException, NumberFormatException {
        boolean correctInput = false;
        List<Integer> result = new ArrayList<>();
        while (!correctInput) {
            System.out.println("교환할 두 숫자를 입력>");
            String input = br.readLine();
            try {
                result = parse(input);
                correctInput = true;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\n잘못 입력하셨습니다. 다시 입력해 주세요.\n");
            }
        }
        return result;
    }

    private List<Integer> parse(String str) throws NumberFormatException{
        List<Integer> result = new ArrayList<>();
        try {
            StringTokenizer st = new StringTokenizer(str, ", ");
            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n < 1 || n > 8) throw new NumberFormatException();
                result.add(n);
            }
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException();
        }
        return result;
    }


}
