package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void askUsername() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
    }
}
