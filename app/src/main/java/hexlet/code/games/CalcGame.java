package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class CalcGame {

    private static final String RULES = "What is the result of the expression?";
    private static final String[] OPERATIONS = new String[] {"+", "-", "*"};

    private static final int QUESTION_NUMBER_BOUND = 30;

    public static void game() {
        List<Exercise> calcExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            String questionOperation
                    = OPERATIONS[Utils.nextRandomInt(OPERATIONS.length)];
            int questionFirstNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);
            int questionSecondNumber = Utils.nextRandomInt(QUESTION_NUMBER_BOUND);

            Exercise exercise = switch (questionOperation) {
                case "+" -> {
                    String question = questionFirstNumber + " + " + questionSecondNumber;
                    String answer = Integer.toString(questionFirstNumber + questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case "-" -> {
                    String question = questionFirstNumber + " - " + questionSecondNumber;
                    String answer = Integer.toString(questionFirstNumber - questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                case "*" -> {
                    String question = questionFirstNumber + " * " + questionSecondNumber;
                    String answer = Integer.toString(questionFirstNumber * questionSecondNumber);
                    yield new Exercise(question, answer);
                }
                default -> throw new RuntimeException("Unknown input: " + questionOperation);
            };

            calcExercises.add(exercise);
        }

        Engine.playGame(RULES, calcExercises);
    }
}
