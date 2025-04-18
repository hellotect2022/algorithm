package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        Map<String, List<Integer>> table = new HashMap<>();
        ArrayList<String> keyOrder = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0 ;i <cnt  ;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            String key = UUID.randomUUID().toString();
            table.put(key, new ArrayList<>(List.of(w,h)));
            keyOrder.add(key);
        }

        table.keySet().stream().forEach(key->{
            List<Integer> value = (List) table.get(key);
            int w = value.get(0);
            int h = value.get(1);
            AtomicInteger rank = new AtomicInteger(1);
            String currentKey = key;

            table.keySet().stream().filter(k ->!k.equals(currentKey)).forEach(e->{
                List<Integer> value2 = (List) table.get(e);
                int w2 = value2.get(0);
                int h2 = value2.get(1);

                if (w2 > w && h2 > h) rank.getAndIncrement();

            });
            value.add(rank.get());
            table.put(key,value);

        });

        keyOrder.forEach(key->{
            int rank = (int) ((List)table.get(key)).get(2);
            sb.append(rank).append(" ");
        });

        System.out.println(sb.toString().trim());
    }


}
