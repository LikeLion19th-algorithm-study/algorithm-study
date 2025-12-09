package week08.boj1431;

import java.io.*;
import java.util.*;

public class 시리얼번호_심민아 {

    // 숫자 합 구하는 함수
    static int sumDigits(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            // 1. 길이 비교
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            // 2. 숫자 합 비교
            int sumA = sumDigits(a);
            int sumB = sumDigits(b);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            // 3. 사전순 비교
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s).append("\n");
        System.out.print(sb);
    }
}