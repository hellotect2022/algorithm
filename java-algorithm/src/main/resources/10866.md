# 🧮 BOJ 10866 - 덱

## 📌 문제 정보

- **문제 번호**: [10866](https://www.acmicpc.net/problem/10866)
- **난이도**: 실버 4
- **분류**: 자료구조, 덱, 구현

---

## 📄 문제 설명

정수를 저장하는 **덱(Deque)**을 구현하고, 주어진 명령들을 처리하는 프로그램을 작성하자.

### 명령 종류

- `push_front X`: 정수 X를 덱의 앞에 넣음
- `push_back X`: 정수 X를 덱의 뒤에 넣음
- `pop_front`: 덱의 가장 앞 정수를 제거하고 출력. 없으면 `-1`
- `pop_back`: 덱의 가장 뒤 정수를 제거하고 출력. 없으면 `-1`
- `size`: 덱에 들어있는 정수의 개수 출력
- `empty`: 덱이 비어있으면 `1`, 아니면 `0`
- `front`: 덱의 가장 앞 정수 출력. 없으면 `-1`
- `back`: 덱의 가장 뒤 정수 출력. 없으면 `-1`

---

## ✅ 입력

- 첫 줄에 명령 수 `N` (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 명령이 주어진다

---

## 📤 출력

- `pop`, `size`, `empty`, `front`, `back` 명령의 출력 결과를 한 줄에 하나씩 출력

---

## 🧠 문제 접근

- `BufferedReader`로 빠르게 입력 받고, `StringBuilder`로 출력 버퍼링
- Java의 `Deque` (`ArrayDeque`)을 사용하여 앞/뒤 양쪽 삽입/삭제 구현
- 각 명령을 `switch-case`로 분기 처리

---

## 🛠 개선 포인트

| 항목         | 개선 전                          | 개선 후                             |
|--------------|----------------------------------|-------------------------------------|
| 입력 처리     | `Scanner` 사용                    | ✅ `BufferedReader`로 속도 개선     |
| 자료구조      | `ArrayList`, `Queue` 등          | ✅ `ArrayDeque`로 양방향 큐 구현    |
| 출력 처리     | `System.out.println()` 반복      | ✅ `StringBuilder`로 일괄 출력      |
| 오답 처리     | `empty` 출력 잘못된 값 (-1 등)    | ✅ 명세대로 `1`, `0` 정확히 출력    |

---

## 💻 코드

```java
package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<String> deck = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "push_back":
                    deck.addLast(command[1]);
                    break;
                case "push_front":
                    deck.addFirst(command[1]);
                    break;
                case "front":
                    sb.append(deck.isEmpty() ? -1 : deck.getFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deck.isEmpty() ? -1 : deck.getLast()).append("\n");
                    break;
                case "size":
                    sb.append(deck.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deck.isEmpty() ? 1 : 0).append("\n");  // ✅ 수정됨
                    break;
                case "pop_front":
                    sb.append(deck.isEmpty() ? -1 : deck.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deck.isEmpty() ? -1 : deck.removeLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void checkDeck(Deque<?> deck) {
        System.out.println("deck : " + deck);
    }
}
