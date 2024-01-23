package hexlet.code.games;

import hexlet.code.Cli;

import java.security.SecureRandom;
import java.util.Random;

public class EvenGame {

    private static final Random random = new SecureRandom();
    private static final String questionPartString = "Question: ";
    private static final String waitAnswerString = "Your answer: ";

    private static final String yesExpectedString = "yes";
    private static final String noExpectedString = "no";
    private static final String rightAnswerCongratulationString = "Correct!";
    private static final String wrongAnswerExplainPattern = "'%s' is wrong answer ;(. Correct answer was '%s'.\n" + "Let's try again, %s!";
    private static final String finalCongratulationPattern = "Congratulations, %s!";

    public static void game() {
        String username = Cli.askUsername();
        boolean wasMistake = false;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {
            int questionNumber = random.nextInt(100);
            System.out.println(questionPartString + questionNumber);

            boolean isEven = questionNumber % 2 == 0;
            String expectedAnswer = isEven ? yesExpectedString : noExpectedString;

            System.out.print(waitAnswerString);
            String userAnswer = Cli.readLine();

            if (expectedAnswer.equals(userAnswer)) {
                System.out.println(rightAnswerCongratulationString);
            } else {
                wasMistake = true;
                System.out.printf(wrongAnswerExplainPattern + "%n", userAnswer, expectedAnswer, username);
            }
        }

        if (!wasMistake) {
            System.out.printf(finalCongratulationPattern + "%n", username);
        }
    }
}
