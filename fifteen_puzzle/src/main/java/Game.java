import javax.swing.*;
import java.io.*;
import java.util.*;

public class Game {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void doGame() {
        int turn = 1;

    }

    private void printTurnAndPuzzle(int turn) {

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
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
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
