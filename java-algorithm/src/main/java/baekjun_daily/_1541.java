package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1541 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> tokenList = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] array = bf.readLine().toCharArray();
        String line = bf.readLine();
        //line.substring(line.indexOf('-'))
        int lastIndex = 0;
        for (int i =0; i<array.length; i++ ) {
            System.out.println(array[i] + " : " +(char) array[i]);
            if ('-'==array[i]) {
                tokenList.add(String.valueOf(Arrays.copyOfRange(array,lastIndex,i)));
                lastIndex = i;
            }else if ('+'==array[i]) {
                tokenList.add(String.valueOf(Arrays.copyOfRange(array,lastIndex,i)));
                lastIndex = i;
            }
        }

        tokenList.forEach(System.out::println);

//        String[] list = bf.readLine().split("[-+]");
//        for (int i=0; i<list.length; i++) {
//            System.out.println(list[i]);
//        }

    }
}
