package hexlet.code;

import hexlet.code.games.EvenGame;

public class App {
    public static void main(String[] args) {
        switch (Cli.gameMenu()) {
            case Greet -> Cli.askUsername();
            case Even -> EvenGame.game();
            case Exit -> Cli.exitGame();
            case Unknown -> {
                Cli.printUnknownGameMessage();
                Cli.exitGame();
            }
        }
    }
}
