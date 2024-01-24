package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalcGame {
    private static final Random RANDOM = new SecureRandom();

    private static final int QUESTION_OPERATION_PLUS = 0;
    private static final int QUESTION_OPERATION_MINUS = 1;
//    private static final int QUESTION_OPERATION_MULTIPLY = 2;

    private static final String QUESTION_STRING_PATTERN = "%1$d %2$s %3$d";

    public static void game() {
        Engine.welcomeGame("What is the result of the expression?");

        List<Exercise> evenExercises = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int questionOperationNumber = RANDOM.nextInt(3);
            int questionFirstNumber = RANDOM.nextInt(30);
            int questionSecondNumber = RANDOM.nextInt(30);

            Exercise exercise = switch (questionOperationNumber) {
                case QUESTION_OPERATION_PLUS -> {
                    String question = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "+", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber + questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case QUESTION_OPERATION_MINUS -> {
                    String question = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "-", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber - questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                default -> {
                    String question = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "*", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber * questionSecondNumber);
                    yield new Exercise(question, answer);
                }
            };

            evenExercises.add(exercise);
        }

        Engine.playGame(evenExercises);
    }
}
