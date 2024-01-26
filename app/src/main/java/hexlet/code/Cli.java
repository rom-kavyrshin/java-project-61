package hexlet.code;

public class Cli {

    public static void askUsername() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String username = Utils.readLine();
        System.out.println("Hello, " + username + "!");
    }
}
