package hexlet.code;

import java.util.Collection;
import java.util.Scanner;

public class Engine {

    public static final int COUNT_OF_ROUNDS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void playGame(String rules, Collection<Exercise> exercises) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String username = SCANNER.nextLine();
        System.out.println("Hello, " + username + "!");
        System.out.println(rules);

        for (Exercise exercise : exercises) {
            System.out.println("Question: " + exercise.question());

            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (exercise.answer().equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println(
                    "'" + userAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + exercise.answer() + "'.\n"
                    + "Let's try again, " + username + "!"
                );
                return;
            }
        }

        System.out.println("Congratulations, " + username + "!");
    }
}
