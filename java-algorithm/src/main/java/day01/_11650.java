package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        List<Pair> list = new ArrayList<>();
        for (int i=0;i<cnt ;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(x,y);
            list.add(pair);
        }

        list.sort((a,b)->a.getX() == b.getX() ? Integer.compare(a.getY(),b.getY()): Integer.compare(a.getX(), b.getX()));
        list.forEach(e-> {
            sb.append(e.getX()).append(" ").append(e.getY()).append("\n");
        });
        System.out.println(sb);
    }

    public static class Pair {
        private int x;
        private int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
