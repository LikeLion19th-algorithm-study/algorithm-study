package week03.boj10773;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 10773번 - 제로
 * --------------------------------------
 * 문제 요약:
 * - 정수가 주어질 때, 0이 나오면 직전에 쓴 수를 지우고,
 *   0이 아니면 스택에 해당 수를 추가한다.
 * - 모든 입력이 끝난 뒤, 스택에 남아 있는 수들의 합을 출력한다.
 *
 * 풀이:
 * - ArrayDeque를 스택처럼 사용하여 수를 저장한다.
 * - 숫자가 0이면 pop()하여 직전 수를 제거하고, 합계(sum)에서도 뺀다.
 * - 숫자가 0이 아니면 push()하고 합계(sum)에 더한다.
 * - 반복문이 끝난 뒤 sum을 그대로 출력하면 된다.
 *
 * 복잡도:
 * - 시간 복잡도: O(N)
 * - 공간 복잡도: O(N)
 *
 * 메모리: 23824KB / 시간: 212ms
 */
public class 제로_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (!stack.isEmpty()) {
                    sum -= stack.pop(); // 이렇게하면 잦은 스택 접근으로 메모리도 늘어나고 시간도 늘어남
                }
            } else {
                stack.push(n);
                sum += n;
            }
        }

        // push, pop 시점마다 합계를 갱신하는게 코드가 더 깔끔하여서 바꿔봤지만,
        // 이렇게 for으로 합을 구하는게 메모리가 더 적고(23492KB) 시간도 더 빨랐다. (208ms)
//        for (int num : stack) {
//            sum += num;
//        }


        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
    }
}
