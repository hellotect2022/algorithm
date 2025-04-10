# 🧮 BOJ 10845 - 큐

## 📌 문제 정보

- **문제 번호**: [10845](https://www.acmicpc.net/problem/10845)
- **난이도**: 실버 4
- **분류**: 자료구조, 큐, 구현

---

## 📄 문제 설명

정수를 저장하는 큐를 구현하고, 주어진 명령어들을 처리하는 프로그램을 작성한다.

### 명령 종류

- `push X`: 정수 X를 큐에 넣는 연산
- `pop`: 큐에서 가장 앞에 있는 정수를 제거하고 출력. 없으면 `-1`
- `size`: 큐에 들어있는 정수의 개수 출력
- `empty`: 큐가 비어있으면 `1`, 아니면 `0`
- `front`: 큐의 가장 앞에 있는 정수를 출력. 없으면 `-1`
- `back`: 큐의 가장 뒤에 있는 정수를 출력. 없으면 `-1`

---

## ✅ 입력

- 첫 줄에 명령의 수 `N` (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 명령이 한 줄에 하나씩 주어짐

---

## 📤 출력

- 명령어가 `pop`, `size`, `empty`, `front`, `back`인 경우 결과를 한 줄에 하나씩 출력

---

## 🧠 문제 접근

- `BufferedReader`를 사용하여 빠르게 입력을 받음
- `Deque<String>` 자료구조를 사용하여 큐를 구현
- `add`, `removeFirst`, `getFirst`, `getLast` 등 Deque의 양방향 기능 활용
- `StringBuilder`로 출력 결과를 모아서 한 번에 출력

---

## 🛠 개선 포인트

| 항목         | 개선 전                         | 개선 후                              |
|--------------|----------------------------------|---------------------------------------|
| 입력 처리     | `Scanner` 사용                   | ✅ `BufferedReader`로 속도 개선       |
| 큐 자료구조   | `ArrayList`, `Queue` 등 혼용    | ✅ `ArrayDeque`로 효율적인 큐 구현    |
| 출력 방식     | `System.out.println()` 반복     | ✅ `StringBuilder`로 모아서 출력      |
| 성능          | 시간 초과 가능성 있음            | ✅ 통과 (빠른 입력/출력 적용)         |

🔗 참고 : Java21 에서는 ArrayList 도 양방향 큐 (Dqueue 상속) 으로 사용가능함 

---

## 💻 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Deque<String> queue = new ArrayDeque<>();
        int loopCnt = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < loopCnt; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    queue.add(command[1]);
                    break;
                case "pop":
                    result.append(queue.isEmpty() ? -1 : queue.removeFirst()).append("\n");
                    break;
                case "size":
                    result.append(queue.size()).append("\n");
                    break;
                case "empty":
                    result.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    result.append(queue.isEmpty() ? -1 : queue.getFirst()).append("\n");
                    break;
                case "back":
                    result.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
                    break;
            }
        }

        System.out.println(result);
    }
}
