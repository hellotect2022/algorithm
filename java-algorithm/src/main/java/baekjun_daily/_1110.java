package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110 {
    public static void main(String[] args) throws IOException {
        // 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고,
        // 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
        //26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
        //위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
        //N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int initialValue = number;
        int number2 =-1;
        int cnt = 0;
        //System.out.println("입력값 : "+number);

        while (number != number2) {
            int f = initialValue/10;
            int b = initialValue%10;
            int tempValue = f+b;
            int newValue = b*10+tempValue%10;
            //System.out.println(f+" + "+b + "="+tempValue+" -> "+newValue);
            initialValue = newValue;

            number2 = initialValue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
