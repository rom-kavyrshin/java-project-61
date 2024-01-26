package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberGame {

    private static final String YES_EXPECTED_STRING = "yes";
    private static final String NO_EXPECTED_STRING = "no";

    private static final int PRIME_NUMBERS_BOUND = 1000;
    private static final int TRICK_NUMBER_BOUND = 10 + 1;

    public static void game() {
        Engine.welcomeGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        List<Exercise> primeNumberExercises = new ArrayList<>();

        ArrayList<Integer> primeNumbers = findPrimeNumbersUpTo(PRIME_NUMBERS_BOUND);

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int questionNumber = primeNumbers.get(Utils.nextRandomInt(primeNumbers.size()));
            int trickNumber;

            if (Utils.nextRandomBoolean()) {
                trickNumber = Utils.nextRandomInt(TRICK_NUMBER_BOUND);
                trickNumber = trickNumber % 2 == 0 ? trickNumber : trickNumber + 1;
                questionNumber += trickNumber;
            }

            String expectedAnswer = primeNumbers.contains(questionNumber) ? YES_EXPECTED_STRING : NO_EXPECTED_STRING;
            primeNumberExercises.add(new Exercise(questionNumber + "", expectedAnswer));
        }

        Engine.playGame(primeNumberExercises);
    }

    private static ArrayList<Integer> findPrimeNumbersUpTo(@SuppressWarnings("SameParameterValue") int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean[] primeNumbers = new boolean[n + 1];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;
        for (int i = 2; i < n; i++) {
            if (primeNumbers[i]) {
                primeList.add(i);
            }
            for (int p : primeList) {
                if (p * i > n) {
                    break;
                }
                primeNumbers[p * i] = false;
            }
        }

        return primeList;
    }
}
