package hangman;

public class App {

    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);
    }
}
