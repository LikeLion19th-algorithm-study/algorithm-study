package week01.boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_박나현 {
    static StringBuilder sb = new StringBuilder();
    static int[] numbers;
    static int[] arr = new int[6];
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            numbers = new int[k];

            for (int i = 0; i < k; i++) {
                int number = Integer.parseInt(st.nextToken());
                numbers[i] =  number;
            }
            backtrack(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backtrack(int start, int depth) {
        if (depth == 6) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            arr[depth] = numbers[i];
            backtrack(i+1, depth+1);
        }
    }
}
