package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int decimalCnt=0;
        for (int i=0; i<cnt;i++) {
                int a = Integer.parseInt(st.nextToken());
                if (isDecimal(a)) decimalCnt++;
        }

        System.out.println(decimalCnt);
    }

    public static boolean isDecimal(int a) {
        if (a <= 1) return false;
        for (int i=2;i<a ;i++) {
            if (a%i==0) return false;
        }
        return true;
    }
}
