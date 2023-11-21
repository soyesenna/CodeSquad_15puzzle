import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle {

    private List<Integer> puzzle;
    private final List<Integer> answer;

    public Puzzle() {
        answer = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        puzzle = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        Collections.shuffle(puzzle);
    }

    public void change(int num1, int num2) {
        int idx1 = puzzle.indexOf(num1);
        int idx2 = puzzle.indexOf(num2);

        int tmp = puzzle.get(idx1);
        puzzle.set(idx1, puzzle.get(idx2));
        puzzle.set(idx2, tmp);
    }

    public boolean checkIsSorted() {
        boolean isSorted = true;
        for (int i = 0; i < 8; i++) {
            if (!puzzle.get(i).equals(answer.get(i))) {
                isSorted = false;
                break;
            }
        }

        return isSorted;
    }

    public List<Integer> getPuzzle() {
        return new ArrayList<>(puzzle);
    }
}
