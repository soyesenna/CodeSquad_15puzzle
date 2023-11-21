package v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import interfaces.*;

public class PuzzleV2 implements Puzzle {

    private List<List<Integer>> puzzle;
    private final List<List<Integer>> answer;

    public PuzzleV2() {
        answer = new ArrayList<>();
        puzzle = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> toInput = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                toInput.add(j + (4 * i));
            }
            answer.add(toInput);
            puzzle.add(new ArrayList<>(toInput));
        }

        for (int i = 0; i < 4; i++) {
            Collections.shuffle(puzzle.get(i));
        }
        Collections.shuffle(puzzle);
    }

    @Override
    public void change(int num1, int num2) throws IllegalArgumentException{
        if (!(num1 == 0 || num2 == 0)) throw new IllegalArgumentException("parameter 두 개 중 하나는 반드시 0이어야 합니다");

        int moveNum = num1 == 0 ? num2 : num1;
        int[] now = findNumIndex(moveNum);
        int[] next = canMove(moveNum, now);

        if (next == null) throw new IllegalArgumentException("움직일 수 있는 칸이 존재하지 않습니다\n");

        puzzle.get(next[0]).set(next[1], moveNum);
        puzzle.get(now[0]).set(now[1], 0);
    }

    private int[] canMove(int num, int[] now) {
        int[][] direction = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        int[] result = new int[2];
        boolean isFind = false;
        for (int[] dir : direction) {
            int nowR = now[0] + dir[0];
            int nowC = now[1] + dir[1];
            if (inRange(nowR, nowC) && puzzle.get(nowR).get(nowC) == 0) {
                result[0] = nowR;
                result[1] = nowC;
                isFind = true;
                break;
            }
        }
        if (isFind){ return result;}
        else return null;
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
