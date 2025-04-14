package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        //ex1();
        ex1_better();

    }

    public static void ex1_better() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        line.chars().mapToObj(e->{
            if (Character.isUpperCase(e)) {
                return (char) ('A'+(e -'A'+13)%26);
            }else if (Character.isLowerCase(e)) {
                return (char) ('a'+(e-'a'+13)%26);
            }
            return (char) e;
        }).forEach(sb::append);
        System.out.println(sb);
    }

    public static void ex1() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        line.chars().map(e -> {
            if (e>=65 && e<=77) { // 대문자
                return e+13;
            }else if (e>77 && e<=90) {
                return e-13;
            }

            if (e>=97 && e<=109) { //소문자
                return e+13;
            }else if (e > 109 && e <=122) {
                return e-13;
            }
            return e;
        }).mapToObj(c->(char) c).forEach(sb::append);

        System.out.println(sb);
    }
}
