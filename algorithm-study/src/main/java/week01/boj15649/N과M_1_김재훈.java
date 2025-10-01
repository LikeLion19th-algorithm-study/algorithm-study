package week01.boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * StringBuilder, StringTokenizer 사용 전 수행 시간: 1740ms
 * StringBuilder, StringTokenizer 사용 후 수행 시간: 252ms
 */
public class N과M_1_김재훈 {

    // 방문한 숫자를 확인하기 위한 배열
    static boolean[] visited;
    // M개를 고른 수열 저장
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[m];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if (depth == arr.length) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                // 재귀 호출
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
