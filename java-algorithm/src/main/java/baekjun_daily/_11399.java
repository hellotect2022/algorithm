package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        int[] list = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int sumOne = 0;
        int sumTotal = 0;

        for (int i : list) {
            sumOne += i;
            sumTotal +=sumOne;
        }
        System.out.println(sumTotal);
    }
}
