package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int q1 = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> n = new HashMap<>();
        String[] m = new String[q1];
        for (int i=0; i<a1;i++) {
            n.put(bf.readLine(),0);
        }
        int cnt=0;
        for (int i=0; i<q1;i++) {
            String s = bf.readLine();
            if (n.containsKey(s)) cnt++;
        }

        System.out.println(cnt);
    }
}
