package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int cnt = Integer.parseInt(inputs[0]);
        int value = Integer.parseInt(inputs[1]);
        List<Integer> coinList = new ArrayList<>();

        for (int i=0; i<cnt; i++) {
            coinList.add(Integer.parseInt(bf.readLine()));
        }
        Collections.reverse(coinList);
        int coinCnt = 0;
        for (Integer i : coinList) {
            if (i <= value) {
                coinCnt += value/i;
                value %= i;
            }
        }

        System.out.println(coinCnt);
    }
}
