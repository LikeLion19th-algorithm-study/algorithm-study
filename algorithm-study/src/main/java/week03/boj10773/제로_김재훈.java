package week03.boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 * 이후 K개의 줄에 정수가 1개씩 주어진다.
 * 정수는 0에서 1,000,000 사이의 값을 가진다.
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 * 재민이가 최종적으로 적어 낸 수의 합을 출력한다.
 * <p>
 * 메모리: 27956KB / 시간: 236ms
 */
public class 제로_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(st.nextToken());
        int result = 0;

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) { // 정수가 "0"일 경우 가장 최근에 쓴 수를 지운다.
                result -= stack.pop();
                continue;
            }
            result += num;
            stack.push(num); // 정수가 "0"이 아닐 경우 해당 수를 쓴다.
        }

/*      처음 풀이 - 스택을 완성한 후 계산

        while (!stack.isEmpty()) {
            result += stack.pop(); // 적어낸 수의 합
        }
*/
        System.out.println(result);
    }
}
