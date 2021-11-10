package hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final Scanner scanner = new Scanner(System.in);

    private Problems problems;
    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void init() {
        problems = new Problems();
    }

    public List<Problem> getProblems() {
        return problems.getProblems();
    }

    public void start() {
        for (Problem problem : getProblems()) {
            Boolean status = true;
            while (status) {
                printProblem(problem);
                printMenu();
                switch (inputMenu()) {
                    case "1":
                        playGame(problem);
                        break;
                    case "2":
                        getHint(problem);
                        break;
                    case "3":
                        status = false;
                        break;
                    case "4":
                        return;
                }
                if (isSameAnswer(problem)) {
                    status = false;
                }
            }
        }
    }

    private void playGame(Problem problem) {
        char letter = inputAnswer();
        check(problem, letter);
    }

    public void printProblem(Problem problem) {
        System.out.println(Arrays.toString(problem.getAlphabets()));
        System.out.println(problem.getEmptyAnswer());
        System.out.println("설명: " + problem.getExplanation());
        System.out.println("목숨: " + player.getLife());
    }

    public void printMenu() {
        System.out.println();
        System.out.println("1.알파벳 입력하기");
        System.out.println("2.힌트 사용하기");
        System.out.println("3.다른 문제");
        System.out.println("4.종료하기");
        System.out.println("메뉴를 선택하세요");
    }

    public String inputMenu() {
        return scanner.next();
    }

    public char inputAnswer() {
        System.out.println("알파벳을 입력하세요");
        return scanner.next().charAt(0);
    }

    private Boolean isSameAnswer(Problem problem) {
        char[] emptyAnswer = problem.getEmptyAnswer();
        if (problem.getAnswer().equals(String.valueOf(emptyAnswer))) {
            return true;
        }
        return false;
    }

    public void getHint(Problem problem) {
        System.out.println("힌트: " + problem.getHint());
        ;
        System.out.println();
    }

    public void check(Problem problem, char c) {
        String answer = problem.getAnswer();

        //입력한 알파벳이 포함되어 있지 않다면
        if (answer.indexOf(c) == -1) {
            //목숨을 하나 차감하고
            System.out.println("차감");
            player.reduceLife();
        }

        for (int i = 0; i < answer.length(); i++) {
            //입력한 알파벳이 포함되어 있다면 포함 된 단어를 보여준다.
            if (answer.indexOf(c, i) != -1) {
                problem.appendAlphabet(c, answer.indexOf(c, i));
            }
        }

        //알파벳을 안보이게 지운다.
        problem.removeAlphabet(c);
    }

}
