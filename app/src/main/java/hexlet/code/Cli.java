package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static Games gameMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        Scanner scanner = new Scanner(System.in);
        String gameNumberString = scanner.nextLine();
        int gameNumber;
        try {
            gameNumber = Integer.parseInt(gameNumberString);
        } catch (Exception ex) {
            gameNumber = -1;
        }
        return switch (gameNumber) {
            case 1 -> Games.Greet;
            case 2 -> Games.Even;
            case 0 -> Games.Exit;
            default -> Games.Unknown;
        };
    }

    public static String askUsername() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        return username;
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void exitGame() {
        System.exit(0);
    }

    public static void printUnknownGameMessage() {
        System.out.println("Unknown game");
    }
}
