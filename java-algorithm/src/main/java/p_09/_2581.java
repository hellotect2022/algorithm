package p_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sNum = Integer.parseInt(bf.readLine());
        int eNum = Integer.parseInt(bf.readLine());
        int decimalCnt=0;
        int sum=0;
        int minValue=0;

        for (int i=eNum;i>=sNum;i--){
            if (isDecimal(i)) {
                sum += i;
                minValue = i;
                decimalCnt ++;
            }
        }

        System.out.println(decimalCnt > 0 ? sum+"\n"+minValue : -1);
    }

    public static boolean isDecimal(int a) {
        if (a==1) return false;
        for (int i=2; i<a; i++) {
            if (a%i==0) return false;
        }
        return true;
    }
}
