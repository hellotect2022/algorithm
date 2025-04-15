# 🧮 BOJ 2675 - 문자열 반복

## 📌 문제 정보

- **문제 번호**: [2675](https://www.acmicpc.net/problem/2675)
- **난이도**: 브론즈 2
- **분류**: 문자열, 구현

---

## 📄 문제 설명

문자열 `S`를 입력받은 후에, 각 문자를 `R`번 반복해 새 문자열 `P`를 만든 후 출력하는 프로그램을 작성하시오.

즉, 첫 번째 문자를 `R`번 반복하고, 두 번째 문자를 `R`번 반복하는 식으로 `P`를 만들면 된다.

> 참고: 문자열 `S`는 QR Code "alphanumeric" 문자만 들어있음  
> (사용 가능한 문자: `0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:`)

---

## ✅ 입력

- 첫 줄에 테스트 케이스 개수 `T` (1 ≤ T ≤ 1,000)
- 각 테스트 케이스는 **정수 R (1 ≤ R ≤ 8)** 과 문자열 `S`가 공백으로 구분되어 주어짐
- 문자열 `S`는 1글자 이상, 20글자 이하

---

## 📤 출력

- 각 테스트 케이스마다 문자열 `P`를 한 줄씩 출력

---

## 🧠 문제 접근

- 각 테스트 케이스에서 주어진 `cnt`만큼 문자를 반복하여 새로운 문자열 생성
- 반복 처리 방식:
    - `case1`: 반복된 문자를 리스트에 추가 후 `StringBuilder`에 모음
    - `case2`: 중첩 for문으로 직접 출력
    - ✅ `case3`: **Stream API 활용**으로 함수형 스타일 구현

---

## 🛠 개선 포인트

| 항목         | 개선 전                            | 개선 후                                 |
|--------------|------------------------------------|------------------------------------------|
| 반복 처리     | for문 반복                          | ✅ `Stream`으로 반복 + flatMap 처리       |
| 출력 처리     | `System.out.println()` 반복        | ✅ `StringBuilder`로 한꺼번에 출력         |
| 가독성        | 복잡한 중첩 루프                   | ✅ 선언형 스타일로 간결화                  |

---

## 💻 코드

```java
package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //case1();
        //case2();
        case3();
    }

    public static void case3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n ; i++) {
            String[] command = br.readLine().split(" ");
            int cnt = Integer.parseInt(command[0]);
            String value = command[1];
            String result = value.chars()
                    .mapToObj(e -> (char) e)
                    .flatMap(ch -> IntStream.range(0, cnt).mapToObj(e -> ch))
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void case2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n ; i++) {
            String[] command = br.readLine().split(" ");
            int cnt = Integer.parseInt(command[0]);
            String value = command[1];

            for (int w=0; w<value.length(); w++) {
                for (int j=0; j<cnt; j++) {
                    sb.append(value.charAt(w));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void case1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            String[] command = line.split(" ");
            if (command.length > 1) {
                int cnt = Integer.parseInt(command[0]);
                String value = command[1];
                ArrayList<Character> list = new ArrayList<>();
                for (char c : value.toCharArray()) {
                    for (int i = 0; i < cnt; i++) {
                        list.add(c);
                    }
                }
                StringBuilder sb = new StringBuilder();
                list.forEach(sb::append);
                System.out.println(sb);
            }
        }
    }
}
