package hexlet.code;

import java.util.List;

public class Engine {

    private static String username;
    private static final String questionPartString = "Question: ";
    private static final String waitAnswerString = "Your answer: ";

    private static final String rightAnswerCongratulationString = "Correct!";
    private static final String wrongAnswerExplainPattern = "'%1$s' is wrong answer ;(. Correct answer was '%2$s'.\n" + "Let's try again, %3$s!";
    private static final String finalCongratulationPattern = "Congratulations, %1$s!";

    public static void welcomeGame(String rules) {
        username = Cli.askUsername();
        System.out.println(rules);
    }

    public static void playGame(List<Exercise> exercises) {
        boolean wasMistake = false;

        for (Exercise exercise : exercises) {
            System.out.println(questionPartString + exercise.getQuestion());

            System.out.print(waitAnswerString);
            String userAnswer = Cli.readLine();

            if (exercise.getAnswer().equals(userAnswer)) {
                System.out.println(rightAnswerCongratulationString);
            } else {
                wasMistake = true;
                System.out.printf(wrongAnswerExplainPattern + "%n", userAnswer, exercise.getAnswer(), username);
                break;
            }
        }

        if (!wasMistake) {
            System.out.printf(finalCongratulationPattern + "%n", username);
        }
    }
}
