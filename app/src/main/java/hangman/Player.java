package hangman;

public class Player {
    private static final int DEFAULT_LIFE = 10;

    private int life;

    public Player() {
        this.life = DEFAULT_LIFE;
    }

    public void reduceLife(){
        life--;
    }

    public int getLife() {
        return life;
    }
}
