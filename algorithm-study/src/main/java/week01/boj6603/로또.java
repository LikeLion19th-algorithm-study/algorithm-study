package week01.boj6603;

// 문제: 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
// 입력: 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다. 입력의 마지막 줄에는 0이 하나 주어진다.
// 출력: 각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다. 각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
// 예제입력:
// 7 1 2 3 4 5 6 7
// 8 1 2 3 5 8 13 21 34
// 0

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    static int k;
    static int[] arr;
    static int[] sel = new int[6];
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                if (i > 0) sb.append(' ');
                sb.append(sel[i]);
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < k; i++) {
            sel[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean firstCase = true;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (!firstCase) sb.append('\n');
            firstCase = false;
            dfs(0, 0);
        }
        System.out.print(sb.toString());
    }
}
