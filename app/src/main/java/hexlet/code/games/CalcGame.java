package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class CalcGame {

    private static final int QUESTION_OPERATION_RANDOM_BOUND = 3;
    private static final int QUESTION_NUMBER_BOUND = 30;
    private static final String[] QUESTION_POSSIBLE_OPERATIONS = new String[] {"+", "-", "*"};

    private static final String QUESTION_STRING_PATTERN = "%1$d %2$s %3$d";

    public static void game() {
        List<Exercise> calcExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            String questionOperation
                    = QUESTION_POSSIBLE_OPERATIONS[Utils.nextRandomInt(QUESTION_OPERATION_RANDOM_BOUND)];
            int questionFirstNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);
            int questionSecondNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);

            Exercise exercise = switch (questionOperation) {
                case "+" -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "+", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber + questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case "-" -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "-", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber - questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case "*" -> {
                    String question
                            = String.format(QUESTION_STRING_PATTERN, questionFirstNumber, "*", questionSecondNumber);
                    String answer = Integer.toString(questionFirstNumber * questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                default -> throw new RuntimeException("Unknown input: " + questionOperation);
            };

            calcExercises.add(exercise);
        }

        Engine.playGame("What is the result of the expression?", calcExercises);
    }
}
