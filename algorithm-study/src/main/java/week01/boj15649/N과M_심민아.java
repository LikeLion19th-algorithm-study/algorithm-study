package week01.boj15649;

import java.io.*;
import java.util.*;

public class N과M_심민아 {
    static int N, M;
    static int[] out;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                out[depth] = i;
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

        out = new int[M];
        used = new boolean[N + 1];
        dfs(0);
        System.out.print(sb.toString());
    }
}
