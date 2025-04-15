# 🔐 BOJ 11655 - ROT13

## 📌 문제 정보

- **문제 번호**: [11655번 - ROT13](https://www.acmicpc.net/problem/11655)
- **난이도**: 브론즈 1
- **분류**: 문자열, 구현

---

## 📄 문제 설명

ROT13은 카이사르 암호(Caesar Cipher)의 일종으로, 영어 알파벳을 13글자씩 밀어서 암호화하는 방식입니다.

- 예를 들어 `"Baekjoon Online Judge"`는 ROT13을 적용하면 `"Onrxwbba Bayvar Whqtr"`가 됩니다.
- ROT13은 **대문자/소문자 알파벳에만 적용**되며, 그 외의 문자(공백, 숫자 등)는 그대로 유지됩니다.
- ROT13은 **두 번 적용하면 원래 문자열로 돌아오는** 특징이 있습니다.

---

## ✅ 조건

- 문자열 S의 길이는 **최대 100자**
- 문자열은 **알파벳 대/소문자**, **숫자**, **공백**으로만 이루어짐

---

## 📥 입력

- 한 줄에 문자열 S가 주어진다.

## 📤 출력

- 문자열 S에 ROT13을 적용한 결과를 출력한다.

---

## 💡 문제 접근

- `String.chars()`를 이용해 각 문자를 아스키 코드로 순회
- `Character.isUpperCase`, `Character.isLowerCase`를 통해 각각의 범위를 파악하여 13글자 밀기 적용
- 아스키 값을 다시 문자로 변환 후 `StringBuilder`에 append
- 예전 방식(`ex1`)과 개선된 방식(`ex1_better`)을 메서드로 분리하여 비교 가능

---

## 💻 코드

```java
package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //ex1(); // 기본 방식
        ex1_better(); // 개선된 방식
    }

    // ✅ 개선된 방법: Character 클래스 활용 + 나머지 연산
    public static void ex1_better() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();

        line.chars().mapToObj(e -> {
            if (Character.isUpperCase(e)) {
                return (char) ('A' + (e - 'A' + 13) % 26);
            } else if (Character.isLowerCase(e)) {
                return (char) ('a' + (e - 'a' + 13) % 26);
            }
            return (char) e;
        }).forEach(sb::append);

        System.out.println(sb);
    }

    // ⛔ 기본 방식: ASCII 범위 수동 체크
    public static void ex1() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();

        line.chars().map(e -> {
            if (e >= 65 && e <= 77) { // A~M
                return e + 13;
            } else if (e > 77 && e <= 90) { // N~Z
                return e - 13;
            }

            if (e >= 97 && e <= 109) { // a~m
                return e + 13;
            } else if (e > 109 && e <= 122) { // n~z
                return e - 13;
            }

            return e; // 비알파벳 문자는 그대로
        }).mapToObj(c -> (char) c).forEach(sb::append);

        System.out.println(sb);
    }
}
