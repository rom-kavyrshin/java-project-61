package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class CalcGame {

    private static final String QUESTION_OPERATION_PLUS = "+";
    private static final String QUESTION_OPERATION_MINUS = "-";
    private static final String QUESTION_OPERATION_MULTIPLY = "*";

    private static final int QUESTION_OPERATION_RANDOM_BOUND = 3;
    private static final int QUESTION_NUMBER_BOUND = 30;
    private static final String[] QUESTION_POSSIBLE_OPERATIONS = new String[] {
        QUESTION_OPERATION_PLUS, QUESTION_OPERATION_MINUS, QUESTION_OPERATION_MULTIPLY
    };

    private static final String QUESTION_STRING_PATTERN = "%1$d %2$s %3$d";

    public static void game() {
        Engine.welcomeGame("What is the result of the expression?");

        List<Exercise> calcExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            String questionOperation
                    = QUESTION_POSSIBLE_OPERATIONS[Utils.nextRandomInt(QUESTION_OPERATION_RANDOM_BOUND)];
            int questionFirstNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);
            int questionSecondNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);

            Exercise exercise = switch (questionOperation) {
                case QUESTION_OPERATION_PLUS -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "+", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber + questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case QUESTION_OPERATION_MINUS -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "-", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber - questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                default -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "*", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber * questionSecondNumber);
                    yield new Exercise(question, answer);
                }
            };

            calcExercises.add(exercise);
        }

        Engine.playGame(calcExercises);
    }
}
