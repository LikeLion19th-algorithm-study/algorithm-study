package week01.boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 로또_심민아 {

    static int N, M;
    static int[] result;
    static int[] check;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth){
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (check[i] == 0) {
                result[depth] = i;
                check[i] = 1;
                dfs(depth + 1);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim()); // 첫 줄 T
        int[] nums = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            nums[i] = n;
            if (n > max) max = n;
        }

        result = new int[M];
        check  = new int[N + 1];

        dfs(0);
        System.out.print(sb.toString());
    }
}
