package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<String> deck = new ArrayDeque<>();
        for (int i=0; i<n ; i++ ){
            String[] command = reader.readLine().split(" ");
            switch (command[0]) {
                case "push_back":
                    deck.addLast(command[1]);
                    break;
                case "push_front":
                    deck.addFirst(command[1]);
                    break;
                case "front":
                    sb.append(deck.isEmpty() ? -1 : deck.getFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deck.isEmpty() ? -1 : deck.getLast()).append("\n");
                    break;
                case "size":
                    sb.append(deck.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deck.isEmpty() ? -1 : 0).append("\n");
                    break;
                case "pop_front":
                    sb.append(deck.isEmpty() ? -1 : deck.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deck.isEmpty() ? -1 : deck.removeLast()).append("\n");
                    break;
            }
            //checkDeck(deck);
        }

        System.out.println(sb);
    }

    public static void checkDeck(Deque deck) {
        System.out.println("deck : "+deck);
    }
}
