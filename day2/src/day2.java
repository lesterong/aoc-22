import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath();
        File file = new File(path + "/day2/src/day2.txt");
        Map<String, Integer> mappings = new HashMap<>() {{
            put("A", 1);
            put("B", 2);
            put("C", 3);
            put("X", 1);
            put("Y", 2);
            put("Z", 3);
        }};
        int score = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                int opponent = mappings.get(input.split(" ")[0]);
                int yours = mappings.get(input.split(" ")[1]);
                if (opponent == yours) {
                    // draw
                    score += 3;
                } else if (opponent + 1 == yours || opponent - 2 == yours) {
                    score += 6;
                } else {
                    score += 0;
                }
                score += yours;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(score);
    }
}
