package baekjun_daily;

import java.util.Scanner;
import java.util.Stack;

public class _10828 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack<String> stringStack = new Stack<>();
        int loopCnt = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<loopCnt;i++) {
            String line = scanner.nextLine();
            if (line.startsWith("pu")) {
                stringStack.push(line.substring(5));
            }else if (line.startsWith("po")) {
                if (!stringStack.isEmpty()) sb.append(stringStack.pop()).append("\n");
                else sb.append(-1).append("\n");
            }else if (line.startsWith("s")) {
                sb.append(stringStack.size()).append("\n");
            }else if (line.startsWith("e")) {
                sb.append(stringStack.size()>0 ? 0:1).append("\n");
            }else if (line.startsWith("t")) {
                if (!stringStack.isEmpty()) sb.append(stringStack.peek()).append("\n");
                else sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
