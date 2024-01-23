package hexlet.code;

public class App {
    public static void main(String[] args) {
        switch (Cli.gameMenu()) {
            case Greet -> Cli.askUsername();
            case Exit -> Cli.exitGame();
            case Unknown -> {
                Cli.printUnknownGameMessage();
                Cli.exitGame();
            }
        }
    }
}
