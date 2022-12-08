import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day2p2 {public static void main(String[] args) {
    String path = new File("").getAbsolutePath();
    File file = new File(path + "/day2/src/day2.txt");
    Map<String, Integer> mappings = new HashMap<>() {{
        put("A", 1);
        put("B", 2);
        put("C", 3);
    }};
    int score = 0;
    try (Scanner sc = new Scanner(file)) {
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            int opponent = mappings.get(input.split(" ")[0]);
            String status = input.split(" ")[1];

            if (status.equals("X")) {
                // lose: my move must be less than the opponent's move
                if (opponent == 1) {
                    score += 3;
                } else {
                    score = score + opponent - 1;
                }
            } else if (status.equals("Y")) {
                // draw
                score += 3;
                score += opponent;
            } else {
                // win: my move must be more than the opponent's
                score += 6;
                if (opponent == 3) {
                    score += 1;
                } else {
                    score = score + opponent + 1;
                }
            }
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    System.out.println(score);
}

}
