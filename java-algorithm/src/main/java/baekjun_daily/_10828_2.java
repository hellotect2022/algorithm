package baekjun_daily;

import java.util.Scanner;
import java.util.Stack;

public class _10828_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
