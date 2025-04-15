package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine().strip();
        //ex1(s);
        ex1_better(s);

    }

    public static void ex1_better(String s) {
            System.out.println(Arrays.stream(s.split(" ")).filter(e->!e.isEmpty()).count());
    }

    public static void ex1(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println(0);
        }else {
            String[] words = s.split(" ");
            System.out.println(words.length);
        }
    }


}
