# 📘 백준 알고리즘 문제 풀이 모음

두 개의 대표적인 브론즈 문제에 대한 설명과 Java 코드 풀이를 정리한 문서입니다.

---

## 🔄 BOJ 1110 - 더하기 사이클

### 📌 문제 정보

- **문제 번호**: [1110번 - 더하기 사이클](https://www.acmicpc.net/problem/1110)
- **난이도**: 브론즈 1
- **분류**: 수학, 구현, 반복문

### 📄 문제 설명

0보다 크거나 같고, 99보다 작거나 같은 정수 N이 주어진다.  
다음과 같은 연산을 반복하여 처음 주어진 수로 돌아오는 데 걸리는 **사이클의 길이**를 구하라.

1. 한 자리 수라면 앞에 0을 붙여 두 자리 수로 만든다.
2. 각 자리 숫자를 더한다.
3. 주어진 수의 **가장 오른쪽 자리 수**와 **합의 가장 오른쪽 자리 수**를 이어붙여 새 수를 만든다.
4. 이 과정을 반복하여 처음 수로 돌아올 때까지의 횟수를 센다.

### ✅ 조건

- 입력: 0 ≤ N ≤ 99
- 출력: 사이클의 길이 (몇 번 반복 후 원래 수로 돌아오는지)


#### 💡 예시 설명

- 2 + 6 = 8 → 68
- 6 + 8 = 14 → 84
- 8 + 4 = 12 → 42
- 4 + 2 = 6 → 26 (처음 수로 돌아옴 → 총 4회)

---

### 💻 Java 코드

```java
package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int initialValue = number;
        int number2 = -1;
        int cnt = 0;

        while (number != number2) {
            int f = initialValue / 10;
            int b = initialValue % 10;
            int tempValue = f + b;
            int newValue = b * 10 + tempValue % 10;
            initialValue = newValue;
            number2 = initialValue;
            cnt++;
        }
        System.out.println(cnt);
    }
}


