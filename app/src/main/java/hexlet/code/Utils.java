package hexlet.code;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new SecureRandom();

    public static String readLine() {
        return SCANNER.nextLine();
    }

    public static int nextRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int nextRandomInt(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }

    public static boolean nextRandomBoolean() {
        return RANDOM.nextBoolean();
    }
}
