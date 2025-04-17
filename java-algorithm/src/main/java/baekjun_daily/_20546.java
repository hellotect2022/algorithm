package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int seed = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int total_timing=0;
        int stock_timing=0;
        int seed_timing=seed;
        int tendency = 0; // -3 : 전량 매수,  3 :전량 매도
        int before_stockPrice = 0;


        int total_bnp=0;
        int stock_bnp=0;
        int seed_bnp=seed;
        Deque<Integer> queue = new ArrayDeque<>();

        while(st.hasMoreTokens()) {
            int stockPrice = Integer.parseInt(st.nextToken());
            stock_bnp += seed_bnp / stockPrice; // 보유 주식
            seed_bnp %= stockPrice;  // 나머지 seed 머니
            total_bnp = seed_bnp+stock_bnp*stockPrice;

            // 성빈의
            if (stockPrice > before_stockPrice) {
                if (queue.size() >=3 ) queue.pop();
                queue.add(1);
            } else if (stockPrice < before_stockPrice) {
                if (queue.size() >= 3) queue.pop();
                queue.add(-1);
            }

            tendency = queue.stream().reduce(0,(a,b)->a+b);


            if (tendency >= 3) { // 전량 매도
                seed_timing += stock_timing * stockPrice;
                stock_timing=0;
            }else  if(tendency <= -3) {
                stock_timing += seed_timing / stockPrice;
                seed_timing %= stockPrice;
            }
            total_timing = seed_timing+stock_timing*stockPrice;

            before_stockPrice = stockPrice;
//            System.out.println("BNP  -> "+" 주식수 :"+stock_bnp + " 잔고 : "+seed_bnp + " 총자산 : "+total_bnp);
//            System.out.println("TIMING  -> "+" 주식수 :"+stock_timing + " 잔고 : "+seed_timing + " 총자산 : "+total_timing + " TENDENCY : "+tendency);
        }

        String result = total_bnp == total_timing ? "SAMESAME" : total_bnp > total_timing ? "BNP" :"TIMING";
        System.out.println(result);
    }
}
