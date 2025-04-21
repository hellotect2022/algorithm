package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class _1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        List<Time> timeList = new ArrayList<>();

        for (int i=0; i<cnt; i++) {
            String[] times = bf.readLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            Time time = new Time(start,end);
            timeList.add(time);
        }

        // greedy 탐색
        // 마지막 시간을 기준으로 가장 적은 숫자로 정렬을 해야 최적의 경로를 찾을 수 있다.
        timeList.sort((a,b)-> {
            return a.getE() == b.getE() ? Integer.compare(a.getS(),b.getS()) : Integer.compare(a.getE(),b.getE());
        });
        timeList.forEach(i->System.out.println(i.getS()+":"+i.getE()));

        ArrayList<Time> greedyList = new ArrayList<>();
        int lastTime=0;
        for (Time time : timeList) {
            int endTime = time.getE();
            int startTime = time.getS();

            if (lastTime <= startTime) {
                greedyList.add(time);
                lastTime = endTime;
            }
        }

        greedyList.forEach(i-> System.out.print("["+i.getS()+":"+i.getE()+"] "));
        System.out.println(greedyList.size());
    }

    static class Time {
        private int s;
        private int e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
        int getS() {
            return s;
        }

        int getE() {
            return e;
        }
    }
}
