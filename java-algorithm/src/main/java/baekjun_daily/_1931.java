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
        //List<Time> timeList = new ArrayList<>();
        Map<String,Time> timeMap = new HashMap<>();
        for (int i=0; i<cnt; i++) {
            String[] times = bf.readLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            Time time = new Time(start,end);
            String uuid = UUID.randomUUID().toString();
            timeMap.put(uuid, time);
        }

        AtomicInteger topDepth = new AtomicInteger();
//        timeMap.keySet().stream().forEach(key-> {
//            ArrayList<String> testedKey = new ArrayList<>();
//
//
//            testedKey.add(key);
//            Time time = timeMap.get(key);
//            int lastTime = time.getE();
//            topDepth.getAndIncrement();
//            List<String> remains = timeMap.keySet().stream().filter(i-> !key.contains(i)).filter(k -> timeMap.get(k).getS() > lastTime).collect(Collectors.toList());
//
//            remains.stream().forEach(key2-> {
//                testedKey.add(key2);
//                Time time2 = timeMap.get(key2);
//                int lastTime2 = time.getE();
//                topDepth.getAndIncrement();
//
//
//            });
        //});
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
