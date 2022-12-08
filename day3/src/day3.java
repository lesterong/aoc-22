import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class day3 {
    public static int convertToPriority(String letter) {
        int value = (int) letter.charAt(0);
        if (value >= 97) {
            return value - 96;
        } else {
            return value - 38;
        }
    }
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath();
        File file = new File(path + "/day3/src/day3.txt");
        int sum = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] arr = sc.nextLine().split("");
                int length = arr.length;
                String letterToCheck = "";
                for (int i = 0; i < length / 2; ++i) {
                    for (int j = length / 2; j < arr.length; ++j) {
                        if (arr[i].equals(arr[j])) {
                            letterToCheck = arr[i];
                            break;
                        }
                    }
                }
                sum += convertToPriority(letterToCheck);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sum);
    }
}
