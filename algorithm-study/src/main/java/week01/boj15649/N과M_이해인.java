package week01.boj15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_이해인 {
    static int N, M;
    static boolean[] used;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(result[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];
        result = new int[M];
        dfs(0);
        System.out.print(sb.toString());
    }
}

