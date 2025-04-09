# 📅 2025-04-08 - 괄호 (백준 9012)

<!-- 문제 링크 -->
- 문제 링크: [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012)
- 난이도: 실버 4
- 알고리즘 분류: 자료구조, 스택, 문자열

---

## 📌 문제 요약

- 괄호 문자열이 주어졌을 때, 올바른 괄호(Valid Parenthesis String, VPS)인지 판단하는 문제
- 조건:
    - '('는 push
    - ')'는 pop
    - 중간에 비어있는데 pop하면 invalid
    - 마지막에 stack이 비어 있어야 valid

---

## 🔍 접근 방식
---

## 💡 배운 점 / 회고

- `Stack<Character>`를 사용하여 '('일 때 push
- ')'일 때 pop 시도
- 만약 pop 전에 stack이 비어 있으면 "NO"
- 반복 후 stack이 비어 있으면 "YES", 아니면 "NO"
- 이렇게 하면 더 직관적으로 구현가능해보임 (단 계산속도는 늦는 듯)

---

## 💻 코드
```java
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder();

        int loopCnt = scanner.nextInt();
        for (int i=0;i<loopCnt;i++){
            String line = scanner.next();
            a.append(check(line)).append("\n");
        }

        System.out.println(a);
    }

    public static String check(String line) {
        if (line.startsWith(")")) return "NO";

        char[] arrays = line.toCharArray();
        int oCap = 0;
        for (char a : arrays){
            if (a == '(') oCap ++;
            else oCap --;
            if (oCap < 0) return "NO";
        }
        //System.out.println(oCap);
        return oCap != 0 ? "NO" : "YES";
    }
}
```

개선된 코드
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean valid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) valid = false;
            System.out.println(valid ? "YES" : "NO");
        }
    }
}