package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvenGame {

    private static final Random random = new SecureRandom();

    private static final String yesExpectedString = "yes";
    private static final String noExpectedString = "no";

    public static void game() {
        Engine.welcomeGame("Answer 'yes' if the number is even, otherwise answer 'no'.");

        List<Exercise> evenExercises = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int questionNumber = random.nextInt(100);
            boolean isEven = questionNumber % 2 == 0;
            String expectedAnswer = isEven ? yesExpectedString : noExpectedString;
            evenExercises.add(new Exercise(questionNumber + "", expectedAnswer));
        }

        Engine.playGame(evenExercises);
    }
}
