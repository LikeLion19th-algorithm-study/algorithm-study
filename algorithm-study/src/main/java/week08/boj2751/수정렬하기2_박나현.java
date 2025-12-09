package week08.boj2751;

import java.io.*;
import java.util.*;

public class 수정렬하기2_박나현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        while (N-- > 0) {
            arr[N] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int num : arr) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
