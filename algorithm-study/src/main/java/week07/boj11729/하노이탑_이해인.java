package week07.boj11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다. (항상 작은 원반이 위)
 *
 * 시작 기둥: 원반이 이동하기 전의 기둥
 * 목표 기둥: 원반이 이동해야하는 기둥
 * 보조 기둥: 나머지 기둥
 *
 * 기둥의 위치는 변하지 않지만 각 기둥의 역할은 변경될 수 있다.
 */

public class 하노이탑_이해인 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, n) - 1).append('\n'); // 총 이동 횟수: 2^n - 1
        hanoi(n, 1, 3, 2);
        System.out.print(sb);
    }

    static void hanoi(int 원반수, int 시작기둥, int 목표기둥, int 보조기둥) {
        if (원반수 == 1) { // 바로 목표기둥으로 원반을 이동, 보조기둥 사용 X
            sb.append(시작기둥).append(' ').append(목표기둥).append('\n');
            return;
        }

        // 시작기둥에 있는 가장 작은 원반은 보조기둥이나 목표기둥으로 이동 가능
        // 하지만 목표기둥은 가장 큰 원반부터 쌓여야하기때문에 보조기둥으로 이동
        // Step 1.가장 큰 원반을 제외한 모든 원반(n-1개)을 보조기둥으로 옮김.
        hanoi(원반수 - 1, 시작기둥, 보조기둥, 목표기둥);

        // Step 2. 시작기둥에 있는 가장 큰 원반을 목표기둥으로 이동
        sb.append(시작기둥).append(' ').append(목표기둥).append('\n');

        // 가장 큰 원반이 목표기둥에 옮겨져있을때, 이후에 이 원반을 이동하거나 이 원반 위에 다른 원반을 못 놓는경우 없음
        // 그래서 이후부터는 n-1로 진행
        // Step 3. 원반수: n-1, 시작기둥 비어있음, 보조기둥에 나머지 원반이 모두있는 상태
        hanoi(원반수 - 1, 보조기둥, 목표기둥, 시작기둥);
    }
}