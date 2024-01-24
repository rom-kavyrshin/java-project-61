package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GCDGame {

    private static final Random RANDOM = new SecureRandom();

    private static final int QUESTION_NUMBER_BOUND = 100;
    private static final int QUESTION_MULTIPLIER_NUMBER_ORIGIN = 1;
    private static final int ANSWER_NUMBER_ORIGIN = 1;
    private static final int ANSWER_NUMBER_BOUND = 19;

    private static final String QUESTION_STRING_PATTERN = "%1$d %2$d";

    public static void game() {
        Engine.welcomeGame("Find the greatest common divisor of given numbers.");

        List<Exercise> gcdExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int sourceNumber = RANDOM.nextInt(ANSWER_NUMBER_ORIGIN, ANSWER_NUMBER_BOUND);

            int questionFirstNumberMultiplier = RANDOM.nextInt(
                    QUESTION_MULTIPLIER_NUMBER_ORIGIN,
                    QUESTION_NUMBER_BOUND / sourceNumber
            );
            int questionSecondNumberMultiplier = RANDOM.nextInt(
                    questionFirstNumberMultiplier,
                    QUESTION_NUMBER_BOUND / sourceNumber
            );

            int questionFirstNumber = sourceNumber * questionFirstNumberMultiplier;
            int questionSecondNumber = sourceNumber * questionSecondNumberMultiplier;

            String question = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, questionSecondNumber);
            String answer = Integer.toString(gcd(questionFirstNumber, questionSecondNumber));

            gcdExercises.add(new Exercise(question, answer));
        }

        Engine.playGame(gcdExercises);
    }

    public static int gcd(int first, int second) {
        return second == 0 ? first : gcd(second, first % second);
    }
}
