package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.PrimeNumberGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;
    private static final int EXIT = 0;

    public static void main(String[] args) {
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

        switch (gameNumber) {
            case GREET -> Cli.askUsername();
            case EVEN -> EvenGame.game();
            case CALC -> CalcGame.game();
            case GCD -> GCDGame.game();
            case PROGRESSION -> ProgressionGame.game();
            case PRIME -> PrimeNumberGame.game();
            case EXIT -> System.exit(0);
            default -> throw new RuntimeException("Unknown game: " + gameNumber);
        }
    }
}
