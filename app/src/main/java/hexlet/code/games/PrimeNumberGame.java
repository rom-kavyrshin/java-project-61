package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Exercise;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class PrimeNumberGame {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final String YES_EXPECTED_STRING = "yes";
    private static final String NO_EXPECTED_STRING = "no";

    private static final int PRIME_NUMBERS_BOUND = 1000;

    public static void game() {
        List<Exercise> primeNumberExercises = new ArrayList<>();

        NavigableSet<Integer> primeNumbers = findPrimeNumbersUpTo(PRIME_NUMBERS_BOUND);

        for (int i = 0; i < Engine.COUNT_OF_ROUNDS; i++) {
            int questionNumber = getPrimeNumberWithProbability50Percent(primeNumbers);
            String expectedAnswer = primeNumbers.contains(questionNumber) ? YES_EXPECTED_STRING : NO_EXPECTED_STRING;
            primeNumberExercises.add(new Exercise(questionNumber + "", expectedAnswer));
        }

        Engine.playGame(RULES, primeNumberExercises);
    }

    private static int getPrimeNumberWithProbability50Percent(NavigableSet<Integer> primeNumbers) {
        int randomNumber = Utils.nextRandomInt(primeNumbers.first(), primeNumbers.last());
        Integer questionNumber = primeNumbers.floor(randomNumber);

        if (Utils.nextRandomBoolean() || questionNumber == null) {
            questionNumber = randomNumber;
        }

        return questionNumber;
    }

    private static NavigableSet<Integer> findPrimeNumbersUpTo(@SuppressWarnings("SameParameterValue") int n) {
        NavigableSet<Integer> primeList = new TreeSet<>();
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
