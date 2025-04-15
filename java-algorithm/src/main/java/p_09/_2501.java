package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2501 {
    // 약수구하기
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(check(a,b));
    }

    public static int check(int a, int b) {
        int index = 1;
        for (int i=1; i<=a;i++ ) {
            if (a%i==0) {
                if (index == b) return i;
                index++;
            }
        }
        return 0;
    }
}
