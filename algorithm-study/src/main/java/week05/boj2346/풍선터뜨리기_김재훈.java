package week05.boj2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다.
 * 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다.
 * 양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다.
 * 이미 터진 풍선은 빼고 이동한다.
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000)이 주어진다.
 * 다음 줄에는 차례로 각 풍선 안의 종이에 적혀 있는 수가 주어진다.  종이에 0은 적혀있지 않다.
 * <p>
 * 메모리: 17544KB / 시간: 188ms
 */
public class 풍선터뜨리기_김재훈 {

    static Deque<Integer> ballon = new ArrayDeque<>();
    static Deque<Integer> number = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n개의 풍선

        initBallon(br, n);

        while (!ballon.isEmpty()) {
            if (solution()) break;
        }

        System.out.println(sb);
    }

    private static void initBallon(BufferedReader br, int n) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ballon.offer(i); // 1부터 n까지 순서대로 풍선 놓기
            number.offer(Integer.parseInt(st.nextToken())); // 풍선에 적힌 번호 순서대로 나열
        }
    }

    private static boolean solution() {
        if (ballon.size() == 1) { // 풍선이 1개만 남으면 반복할 필요 없이 바로 반환하면 된다.
            sb.append(ballon.poll());
            return true;
        }

        Integer peekFirst = number.peekFirst();

        if (peekFirst > 0) { // 확인한 수가 양수일 경우
            sb.append(ballon.pollFirst()).append(" ");
            Integer positive = number.pollFirst();

            for (int i = 0; i < positive - 1; i++) { // k-1 만큼 반복하며
                ballon.offerLast(ballon.pollFirst()); // 가장 앞의 수를 가장 뒤로 보낸다.
                number.offerLast(number.pollFirst()); // 풍선을 옮길 때 번호도 함께 옮긴다.
            }
            // else if 가 아닌 if로 실행 시 오류 발생!
        } else if (peekFirst < 0) { // 확인한 수가 음수일 경우
            sb.append(ballon.pollFirst()).append(" ");
            int negative = Math.abs(number.pollFirst()); // 음수이므로 절대값으로 바꿔준다.

            for (int i = 0; i < negative; i++) { // k 만큼 반복하며
                ballon.offerFirst(ballon.pollLast()); // 가장 뒤의 수를 가장 앞으로 보낸다.
                number.offerFirst(number.pollLast()); // 풍선을 옮길 때 번호도 함께 옮긴다.
            }
        }
        return false;
    }
}
