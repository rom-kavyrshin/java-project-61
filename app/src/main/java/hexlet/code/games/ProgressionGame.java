package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProgressionGame {

    private static final int PROGRESSION_MIN_LENGTH = 5;
    private static final int PROGRESSION_MAX_LENGTH = 10 + 1;

    private static final int PROGRESSION_START_NUMBER_MIN = 2;
    private static final int PROGRESSION_START_NUMBER_MAX = 20;

    private static final int PROGRESSION_STEP_MIN = 2;
    private static final int PROGRESSION_STEP_MAX = 9;

    public static void game() {
        Engine.welcomeGame("What number is missing in the progression?");

        List<Exercise> progressionExercises = new ArrayList<>();

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int progressionLength = Utils.nextRandomInt(PROGRESSION_MIN_LENGTH, PROGRESSION_MAX_LENGTH);
            int invisibleItemPosition = Utils.nextRandomInt(progressionLength);

            int progressionStartNumber
                    = Utils.nextRandomInt(PROGRESSION_START_NUMBER_MIN, PROGRESSION_START_NUMBER_MAX);
            int progressionStep = Utils.nextRandomInt(PROGRESSION_STEP_MIN, PROGRESSION_STEP_MAX);

            String[] progression = makeProgression(progressionStartNumber, progressionStep, progressionLength);
            String answerNumber = progression[invisibleItemPosition];
            progression[invisibleItemPosition] = "..";

            String question = String.join(" ", progression);

            progressionExercises.add(new Exercise(question, answerNumber));
        }

        Engine.playGame(progressionExercises);
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];

        for (int i = 0; i < length; i += 1) {
            progression[i] = Integer.toString(first + i * step);
        }

        return progression;
    }
}
