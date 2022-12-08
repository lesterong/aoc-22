import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath();
        File file = new File(path + "/day1/src/day1.txt");
        ArrayList<Integer> calories = new ArrayList<>();
        try (Scanner sc = new Scanner(file)) {
            int currSum = 0;
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    calories.add(currSum);
                    currSum = 0;
                } else {
                    currSum += Integer.parseInt(input);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Collections.max(calories));
    }
}
