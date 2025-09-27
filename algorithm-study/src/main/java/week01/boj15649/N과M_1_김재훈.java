package week01.boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
public class N과M_1_김재훈 {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        // N까지의 자연수 중 방문한 숫자 확인
        visited = new boolean[n];
        // M개를 고른 수열 저장
        arr = new int[m];

        // 재귀
        backtracking(0);
    }

    static void backtracking(int depth) {
        if (depth == arr.length) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
