import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
//        GameV1 gameV1 = new GameV1();
//        gameV1.doGame();
        List<List<Integer>> tmp = new ArrayList<>();
        tmp.add(List.of(1, 2, 3, 4));
        tmp.add(List.of(5, 6, 7, 8));
        Collections.shuffle(tmp);
        System.out.println(tmp);

    }
}
