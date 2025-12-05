package week08.boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
 * 첫째 줄에 수의 개수 N / 둘째 줄부터 N개의 줄에는 수 / 수는 중복되지 않는다.
 * 메모리: 111348KB | 시간: 1296ms
 */
public class 수정렬하기_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 수의 개수 N
        int[] arr = new int[n]; // 수를 저장할 배열

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 배열 채우기
        }

        Arrays.sort(arr); // 오름차순 정렬
        Arrays.stream(arr).forEach(v -> sb.append(v).append("\n"));
        System.out.println(sb);
    }
}
