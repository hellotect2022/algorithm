# 🧮 BOJ 10828 - 스택

## 📌 문제 정보

- **문제 번호**: [10828](https://www.acmicpc.net/problem/10828)
- **난이도**: 실버 4
- **분류**: 자료구조, 스택, 구현

---

## 📄 문제 설명

정수를 저장하는 스택을 구현하고, 주어진 명령어들을 처리하는 프로그램을 작성한다.

### 명령 종류

- `push X`: 정수 X를 스택에 추가
- `pop`: 스택의 최상단 요소를 제거하고 출력. 없으면 `-1`
- `size`: 현재 스택에 들어있는 정수 개수 출력
- `empty`: 스택이 비어있으면 `1`, 아니면 `0` 출력
- `top`: 스택의 최상단 요소 출력. 없으면 `-1`

---

## ✅ 입력

- 첫 줄에 명령의 수 `N` (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 명령이 한 줄에 하나씩 주어짐

---

## 📤 출력

- 명령어가 `pop`, `size`, `empty`, `top`인 경우 결과를 한 줄에 하나씩 출력

---

## 🧠 문제 접근

- 명령어를 빠르게 구분하기 위해 `split()`과 `switch-case` 문 사용
- `Stack<Integer>` 자료구조를 사용하여 push/pop 등 수행
- 입출력 최적화를 위해 `StringBuilder`로 결과를 모아서 한 번에 출력

---

## 🛠 개선 포인트

| 항목       | 개선 전                             | 개선 후                             |
|------------|-------------------------------------|-------------------------------------|
| 입력 파싱   | `startsWith("pu")` 등 문자열 비교     | `split()` + `switch` 구조로 명확히 |
| 자료형      | `Stack<String>`                    | `Stack<Integer>`로 숫자 다룸       |
| 출력 방식   | `System.out.println()` 반복 호출    | `StringBuilder` + `System.out.print` 한 번만 호출 |
| 성능        | 시간 초과 가능성 있음               | 개선 후 통과                        |

---

## 💻 코드

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
