package baekjun_daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _1541 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> tokenList = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // -를 기준으로 문자열을 분할합니다.
        // 첫 번째 파트는 그냥 덧셈합니다.
        // 이후 파트들은 모두 내부의 +를 계산한 후 결과값에서 뺍니다.
        String line = bf.readLine();
        String[] valueList = line.split("[-]");
        int sum = Arrays.stream(valueList[0].split("[+]")).mapToInt(Integer::parseInt).sum();

        for (int i=1; i< valueList.length; i++) {
            //System.out.println(valueList[i]);
            String[] value = valueList[i].split("[+]");
            for (String val : value) {
                sum -= Integer.parseInt(val);
            }
        }

        System.out.println(sum);
    }
}
