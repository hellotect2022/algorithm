package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Deque<String> queue = new ArrayDeque<>();
        int loopCnt = Integer.parseInt(reader.readLine());
        for (int i=0 ; i<loopCnt; i++){
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "push" :
                    queue.add(command[1]);
                    break;
                case "pop" :
                    result.append(queue.isEmpty() ? -1 : queue.removeFirst()).append("\n");
                    break;
                case "size":
                    result.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    result.append(queue.isEmpty() ? 1:0).append("\n");
                    break;
                case "front" :
                    result.append(queue.isEmpty() ? -1 : queue.getFirst()).append("\n");
                    break;
                case "back" :
                    result.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");

            }
        }
        System.out.println(result);

    }
}