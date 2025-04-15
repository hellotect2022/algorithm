package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _2675 {
    public static void main(String[] args) throws IOException {
        //case1();
        //case2();
        case3();
    }

    public static void case3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n ; i++) {
            String[] command = br.readLine().split(" ");
            int cnt = Integer.parseInt(command[0]);
            String value= command[1];
            String result = value.chars()
                    .mapToObj(e->(char)e)
                    .flatMap(ch-> IntStream.range(0,cnt).mapToObj(e->ch))
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void case2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] command;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n ; i++) {
            command = br.readLine().split(" ");
            String value= command[1];
            int cnt = Integer.parseInt(command[0]);

            for (int w=0; w<value.length();w++) {
                for (int j=0; j<cnt; j++ ) {
                    sb.append(value.charAt(w));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void case1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            String[] command = line.split(" ");
            if (command.length > 1) {
                int cnt = Integer.parseInt(command[0]);
                String value = command[1];
                ArrayList<Character> list = new ArrayList<Character>();
                for (char c : value.toCharArray()) {
                    for (int i=0; i<cnt;i++) {
                        list.add(c);
                    }
                }
                StringBuilder sb = new StringBuilder();
                list.forEach(sb::append);
                System.out.println(sb);
            }
        }
    }
}
