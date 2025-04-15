package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5086 {
    // 5086 배수와 약수
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a==0 && b==0) break;

            String result = check(a,b);
            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }

    public static String check(int a, int b) {
        if (a%b==0) return "multiple";
        else if (b%a==0) return "factor";
        else return "neither";
    }
}
