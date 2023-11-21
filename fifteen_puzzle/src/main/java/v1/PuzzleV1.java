package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import interfaces.*;

public class PuzzleV1 implements Puzzle {

    private List<Integer> puzzle;
    private final List<Integer> answer;

    public PuzzleV1() {
        answer = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        puzzle = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        Collections.shuffle(puzzle);
    }
    @Override
    public void change(int num1, int num2) {
        int idx1 = puzzle.indexOf(num1);
        int idx2 = puzzle.indexOf(num2);

        int tmp = puzzle.get(idx1);
        puzzle.set(idx1, puzzle.get(idx2));
        puzzle.set(idx2, tmp);
    }
    @Override
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
