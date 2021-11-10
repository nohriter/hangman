package hangman;

import java.util.Scanner;

public class Game {
    public static final Scanner scanner = new Scanner(System.in);

    private Problems problems;
    private Player player;

    public Game(Player player) {
        this.player = player;
    }


}
