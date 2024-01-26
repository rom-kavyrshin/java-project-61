package hexlet.code;

import java.util.List;

public class Engine {

    public static final int COUNT_OF_ROUNDS = 3;

    private static String username;

    public static void welcomeGame(String rules) {
        askUsername();
        System.out.println(rules);
    }

    public static void playGame(List<Exercise> exercises) {
        boolean wasMistake = false;

        for (Exercise exercise : exercises) {
            System.out.println("Question: " + exercise.question());

            System.out.print("Your answer: ");
            String userAnswer = Utils.readLine();

            if (exercise.answer().equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                wasMistake = true;
                System.out.println(
                    "'" + userAnswer + "' is wrong answer ;(. "
                    + "Correct answer was '" + exercise.answer() + "'.\n"
                    + "Let's try again, " + username + "!"
                );
                break;
            }
        }

        if (!wasMistake) {
            System.out.println("Congratulations, " + username + "!");
        }
    }

    public static void askUsername() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username = Utils.readLine();
        System.out.println("Hello, " + username + "!");
    }
}
