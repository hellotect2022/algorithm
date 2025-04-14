# 🧮 BOJ 14425 - 문자열 집합

## 📌 문제 정보

- **문제 번호**: [14425번 - 문자열 집합](https://www.acmicpc.net/problem/14425)
- **난이도**: 실버 3
- **분류**: 문자열, 자료구조, 해시

---

## 📄 문제 설명

총 N개의 문자열로 이루어진 집합 S가 주어진다.  
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

---

## ✅ 조건

- 1 ≤ N, M ≤ 10,000
- 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않음
- 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없음

---

## 📥 입력

- 첫째 줄: N, M (공백으로 구분)
- 다음 N줄: 집합 S에 포함된 문자열
- 다음 M줄: 검사해야 할 문자열

---

## 📤 출력

- M개의 문자열 중 집합 S에 포함된 문자열의 개수 출력

---

## 💡 문제 접근

- 문자열을 빠르게 탐색해야 하므로 `HashMap` 혹은 `HashSet`을 활용
- 집합 S의 문자열들을 저장한 뒤, 검사 문자열이 존재하는지만 확인
- 시간 복잡도: O(N + M), 각 문자열의 조회는 O(1)

---

## 💻 코드

```java
package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a1 = Integer.parseInt(st.nextToken()); // N
        int q1 = Integer.parseInt(st.nextToken()); // M

        HashMap<String, Integer> n = new HashMap<>();
        for (int i = 0; i < a1; i++) {
            n.put(bf.readLine(), 0); // 집합 S에 문자열 추가
        }

        int cnt = 0;
        for (int i = 0; i < q1; i++) {
            String s = bf.readLine();
            if (n.containsKey(s)) cnt++; // 존재하면 카운트 증가
        }

        System.out.println(cnt); // 결과 출력
    }
}
