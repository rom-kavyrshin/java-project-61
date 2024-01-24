package hexlet.code;

import java.util.List;

public class Engine {

    public static final int COUNT_OF_ROUNDS = 3;

    private static final String QUESTION_PART_STRING = "Question: ";
    private static final String WAIT_ANSWER_STRING = "Your answer: ";

    private static final String RIGHT_ANSWER_CONGRATULATION_STRING = "Correct!";
    private static final String WRONG_ANSWER_EXPLAIN_PATTERN = "'%1$s' is wrong answer ;(. Correct answer was '%2$s'.\n" + "Let's try again, %3$s!";
    private static final String FINAL_CONGRATULATION_PATTERN = "Congratulations, %1$s!";

    private static String username;

    public static void welcomeGame(String rules) {
        username = Cli.askUsername();
        System.out.println(rules);
    }

    public static void playGame(List<Exercise> exercises) {
        boolean wasMistake = false;

        for (Exercise exercise : exercises) {
            System.out.println(QUESTION_PART_STRING + exercise.getQuestion());

            System.out.print(WAIT_ANSWER_STRING);
            String userAnswer = Cli.readLine();

            if (exercise.getAnswer().equals(userAnswer)) {
                System.out.println(RIGHT_ANSWER_CONGRATULATION_STRING);
            } else {
                wasMistake = true;
                System.out.printf(WRONG_ANSWER_EXPLAIN_PATTERN + "%n", userAnswer, exercise.getAnswer(), username);
                break;
            }
        }

        if (!wasMistake) {
            System.out.printf(FINAL_CONGRATULATION_PATTERN + "%n", username);
        }
    }
}
