package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11653 {
    public static void main(String[] args) throws IOException {
        //sol_idiot();
        sol_great();
    }

    public static void sol_great() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=2; i<=Math.sqrt(N);i++) {
            while(N%i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        if (N != 1) sb.append(N);

        System.out.println(sb);
    }

    public static int getDecimal(int a) {
        for (int i=2; i<a; i++) {
            if (a%i ==0 ) return i;
        }
        return a;
    }

    public static void sol_idiot() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        if (N == 1) return; // 1 인경우 바로 종료

        while (N%2==0) {
            N = N/2;
            sb.append(2).append("\n");
        }

        while (N%3 == 0) {
            N = N/3;
            sb.append(3).append("\n");
        }

        while (N != 1 && N%getDecimal(N) == 0) {
            sb.append(getDecimal(N)).append("\n");
            N = N/getDecimal(N);


        }


        System.out.println(sb);
    }
}
