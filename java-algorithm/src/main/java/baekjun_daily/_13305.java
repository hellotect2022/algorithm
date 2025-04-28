package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13305 {
    public static void main(String[] args) throws IOException {
        // 58점짜리 답
        //result_58();

        // ** 자릿수에 따른 자료형을 제대로 판별해야한다.
        // 100점짜리 답
        result_100();
    }

    public static void result_100() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine())-1;
        String[] distanceLine = bf.readLine().split(" ");
        String[] priceLine = bf.readLine().split(" ");

        long lastPrice= Long.parseLong(priceLine[0]);
        long sum = lastPrice*Long.parseLong(distanceLine[0]);

        for (int i=1; i<cnt; i++) {
            long price = Long.parseLong(priceLine[i]);
            long distance = Long.parseLong(distanceLine[i]);

            if (lastPrice > price) {
                sum += price*distance;
                lastPrice = price;
            }else {
                sum += lastPrice*distance;
            };
        }

        System.out.println(sum);
    }

    public static void result_58() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine())-1;
        String[] distanceLine = bf.readLine().split(" ");
        String[] priceLine = bf.readLine().split(" ");

        long lastPrice= Long.parseLong(priceLine[0]);
        long sum = lastPrice*Long.parseLong(distanceLine[0]);

        for (int i=1; i<cnt; i++) {
            long price = Integer.parseInt(priceLine[i]);
            long distance = Integer.parseInt(distanceLine[i]);

            if (lastPrice > price) {
                sum += price*distance;
                lastPrice = price;
            }else {
                sum += lastPrice*distance;
            };
        }

        System.out.println(sum);
    }
}
