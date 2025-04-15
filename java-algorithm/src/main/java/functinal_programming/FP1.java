package functinal_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FP1 {
    // Student
    //???? ???? ??? ??? ??? ?????.
    //???: 80? ??? ??? ?? ???? ??????.
    //?? ?? ??: ???? ???? ?? ??? ?????.
    //?? ??: ???? ???? ??? ??, ??? ?? ??? ?????.

    // ==== ?? ====
    // 80? ??? ???:
    //Alice: 85
    //Charlie: 90
    //Eve: 95
    //?? ??: 90.0

    public static void main(String[] args){
        List<Student> list = Arrays.asList(
                new Student("Alice", 85),
                new Student("Bob", 70),
                new Student("Charlie", 90),
                new Student("David", 60),
                new Student("Eve", 95)
        );
        StringBuilder sb = new StringBuilder();
        double avg = list.stream().filter(student -> student.getScore() >= 80)
            .peek(s->sb.append((s.getName()))
                    .append(": ")
                    .append(s.getScore())
                    .append("\n"))
            .mapToInt(student -> student.getScore())
            .average()
            .orElse(0);

        sb.append("Average: ").append(avg);
        System.out.println(sb);
    }

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }
        public  int getScore() {
            return this.score;
        }
    }
}
