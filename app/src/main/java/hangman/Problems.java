package hangman;

import java.util.ArrayList;
import java.util.List;

public class Problems {
    private List<Problem> problems;

    public Problems() {

        this.problems = new ArrayList<>();
        Problem apple = new Problem("apple", "맛있는 과일", "원숭이 엉덩이는 빨개");
        Problem subway = new Problem("subway", "대중교통", "버스말고");
        Problem dog = new Problem("dog", "반려동물", "고양이 말고");
        Problem soccer = new Problem("soccer", "구기 종목", "손흥민");
        Problem kimchi = new Problem("kimchi", "전통 음식", "오래두고 먹을 수 있음");
        Problem teacher = new Problem("teacher", "단", "호눅스");

        problems = List.of(apple, subway, dog, soccer, kimchi, teacher);

    }

    public List<Problem> getProblems() {
        return problems;
    }
}
