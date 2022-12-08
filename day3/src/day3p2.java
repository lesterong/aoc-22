import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class day3p2 {
    public static int convertToPriority(String letter) {
        int value = letter.charAt(0);
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
                String letterToCheck = findCommonLetter(sc.nextLine(), sc.nextLine(), sc.nextLine());
                sum += convertToPriority(letterToCheck);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sum);
    }

    private static String findCommonLetter(String firstElf, String secondElf, String thirdElf) {
        String common = "";
        String[] first = firstElf.split("");
        for (String s : first) {
            if (secondElf.contains(s) && thirdElf.contains(s)) {
                common = s;
                break;
            }
        }
        return common;
    }
}
