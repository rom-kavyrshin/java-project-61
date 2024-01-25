package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeNumberGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        switch (gameMenu()) {
            case Greet -> Cli.askUsername();
            case Even -> EvenGame.game();
            case Calc -> CalcGame.game();
            case Gcd -> GCDGame.game();
            case Progression -> ProgressionGame.game();
            case Prime -> PrimeNumberGame.game();
            case Exit -> exitGame();
            default -> {
                printUnknownGameMessage();
                exitGame();
            }
        }
    }

    public static Games gameMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String gameNumberString = scanner.nextLine();
        int gameNumber;
        try {
            gameNumber = Integer.parseInt(gameNumberString);
        } catch (Exception ex) {
            gameNumber = -1;
        }
        System.out.println();
        return switch (gameNumber) {
            case 1 -> Games.Greet;
            case 2 -> Games.Even;
            case 3 -> Games.Calc;
            case 4 -> Games.Gcd;
            case 5 -> Games.Progression;
            case 6 -> Games.Prime;
            case 0 -> Games.Exit;
            default -> Games.Unknown;
        };
    }

    public static void exitGame() {
        System.exit(0);
    }

    public static void printUnknownGameMessage() {
        System.out.println("Unknown game");
    }
}
