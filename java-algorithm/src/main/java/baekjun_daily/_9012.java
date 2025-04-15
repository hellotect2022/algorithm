package baekjun_daily;

import java.io.IOException;
import java.util.Scanner;

public class _9012 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder();

        int loopCnt = scanner.nextInt();
        for (int i=0;i<loopCnt;i++){
            String line = scanner.next();
            a.append(check(line)).append("\n");
        }

        System.out.println(a);
    }

    public static String check(String line) {
        if (line.startsWith(")")) return "NO";

        char[] arrays = line.toCharArray();
        int oCap = 0;
        for (char a : arrays){
            if (a == '(') oCap ++;
            else oCap --;
            if (oCap < 0) return "NO";
        }
        //System.out.println(oCap);
        return oCap != 0 ? "NO" : "YES";
    }
}
