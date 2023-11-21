import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleV2 implements Puzzle{

    private List<List<Integer>> puzzle;
    private final List<List<Integer>> answer;

    public PuzzleV2() {
        answer = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> toAnswer = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                toAnswer.add(j + (4 * i));
            }
            answer.add(toAnswer);
        }
        puzzle = new ArrayList<>(answer);

        for (int i = 0; i < 4; i++) {
            Collections.shuffle(puzzle.get(i));
        }
        Collections.shuffle(puzzle);
    }

    @Override
    public void change(int num1, int num2) {
        if (!(num1 == 0 || num2 == 0)) return;


    }

    @Override
    public boolean checkIsSorted() {
        return false;
    }

    @Override
    public List<Integer> getPuzzle() {
        return null;
    }
}
