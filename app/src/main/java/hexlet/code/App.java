package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        switch (gameMenu()) {
            case Greet -> Cli.askUsername();
            case Even -> EvenGame.game();
            case Calc -> CalcGame.game();
            case Exit -> exitGame();
            case Unknown -> {
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
            case 3 -> Games.Calc;
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
