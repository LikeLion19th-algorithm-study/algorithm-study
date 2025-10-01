package week01.boj9020;

// 문제: 2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
// 입력: 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.
// 출력: 각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int MAX = 10000;
        boolean[] isComposite = new boolean[MAX + 1];
        isComposite[0] = isComposite[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= MAX; j += i) isComposite[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a = n / 2;
            int b = n / 2;

            while (a > 1) {
                if (!isComposite[a] && !isComposite[b]) {
                    sb.append(a).append(' ').append(b).append('\n');
                    break;
                }
                a--; b++;
            }
        }
        System.out.print(sb.toString());
    }
}
