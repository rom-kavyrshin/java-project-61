package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class EvenGame {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final String YES_EXPECTED_STRING = "yes";
    private static final String NO_EXPECTED_STRING = "no";

    private static final int QUESTION_NUMBER_BOUND = 100;

    public static void game() {
        List<Exercise> evenExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int questionNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);
            boolean isEven = questionNumber % 2 == 0;
            String expectedAnswer = isEven ? YES_EXPECTED_STRING : NO_EXPECTED_STRING;
            evenExercises.add(new Exercise(questionNumber + "", expectedAnswer));
        }

        Engine.playGame(RULES, evenExercises);
    }
}
