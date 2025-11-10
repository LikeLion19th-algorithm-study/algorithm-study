package main.java.week05.boj13417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 카드문자열_양민섭 {
    //메모리 : 29296KB, 시간 : 284ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 개수

        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 카드 개수
            StringTokenizer st = new StringTokenizer(br.readLine());

            Deque<Character> deque = new LinkedList<>();

            // 첫번째 카드
            deque.add(st.nextToken().charAt(0));
            // 나머지 카드
            for (int i = 1; i < N; i++) {
                char c = st.nextToken().charAt(0);
                if (c <= deque.peekFirst()) { // char 은 기본형 타입이라 null 못 받음. 그래서 NPE 경고 나옴.
                    deque.addFirst(c);  // 가장 앞 글자보다 작 . 같 왼쪽에 추가
                } else {
                    deque.addLast(c);   // 아니라면 오른쪽에 추가
                }
            }

            // 덱을 문자열로 변환
            StringBuilder sb = new StringBuilder();
            for (char c : deque) {
                sb.append(c);
            }
            result.append(sb).append("\n"); // 테스트끼리 분리
        }
        System.out.print(result);
    }
}