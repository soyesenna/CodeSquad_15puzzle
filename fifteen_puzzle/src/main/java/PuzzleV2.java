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

    private boolean canMove(int num) {
        int[][] direction = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        int[] now = findNumIndex(num);
        boolean result = false;
        for (int[] dir : direction) {
            int nowR = now[0] + dir[0];
            int nowC = now[1] + dir[1];
            if (inRange(nowR, nowC) && puzzle.get(nowR).get(nowC) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean inRange(int r, int c) {
        return r >= 0 && r < 4 && c >= 0 && c < 4;
    }

    private int[] findNumIndex(int num) {
        int[] result = new int[2];
        boolean isFind = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.puzzle.get(i).get(j) == num){
                    result[0] = i;
                    result[1] = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) break;
        }
        return result;
    }

    @Override
    public boolean checkIsSorted() {
        boolean result = true;
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!puzzle.get(i).get(j).equals(answer.get(i).get(j))) {
                    result = false;
                    check = true;
                    break;
                }
            }
            if (check) break;
        }
        return result;
    }

    public List<List<Integer>> getPuzzle() {
        return new ArrayList<>(puzzle);
    }

}
