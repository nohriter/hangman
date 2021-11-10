package hangman;

public class Problem {
    private char[] alphabets = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};

    private char[] emptyAnswer;
    private String answer;
    private String explanation;
    private String hint;

    public Problem(String answer, String explanation, String hint) {
        this.answer = answer;
        this.explanation = explanation;
        this.hint = hint;
        createEmptyAnswer(answer);
    }

    public void createEmptyAnswer(String answer) {
        emptyAnswer = new char[answer.length()];

        for (int i = 0; i < answer.length(); i++) {
            emptyAnswer[i] = '_';
        }
    }

    public void appendAlphabet(char c, int i) {
        this.emptyAnswer[i] = c;
    }

    public void removeAlphabet(char c) {
        this.alphabets[c - 97] = '#';
    }

    public char[] getEmptyAnswer() {
        return emptyAnswer;
    }

    public char[] getAlphabets() {
        return alphabets;
    }

    public Problem getProblem() {
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHint() {
        return hint;
    }
}
