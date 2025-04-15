package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) break;
            sb.append(num);
            int sum=0;
            for (int i=1; i< num; i++) {
                if (num%i == 0) {
                    sum += i;
                    String icon = i==1 ? " = " : " + ";
                    sb.append(icon).append(i);
                }
            }

            String result = sum == num ? sb.toString() : num+" is NOT perfect.";
            System.out.println(result);
        }
    }
}
