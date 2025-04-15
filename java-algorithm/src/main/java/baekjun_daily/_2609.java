package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609 {
    public static void main(String[] args) throws IOException {
        // 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = 0;
        int max = 0;

        min = a>b ? gcd(a,b) : gcd(b,a); // 최소공배수 구하는법 유클리드 호제법에 대한 이해를 하면 쉬워짐
        max = a*b/min; // 최소 공배수는 두수의 곲 / 최대 공약수 하면됨 

        
        // 답 출력
        StringBuilder sb = new StringBuilder();
        sb.append(min).append("\n").append(max);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        return a%b==0 ? b : gcd(b,a%b);
    }
}
