package week08.boj1431;

import java.io.*;
import java.util.*;

public class 시리얼번호_박나현 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        while (N-- > 0) {
            arr[N] = br.readLine();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if(s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }

            int sum1 = getSum(s1);
            int sum2 = getSum(s2);

            if (sum1 != sum2) {
                return sum1 - sum2;
            }

            return s1.compareTo(s2);
        });

        for (String str : arr) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    private static int getSum(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
