package week07.boj17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출력을 원하는 재귀 횟수 N(1 ≤ N ≤ 50)이 주어진다.
 * 재귀 횟수에 따른 챗봇의 응답을 출력한다.
 * 메모리: 14348KB | 시간: 112ms
 */
public class 재귀함수가뭔가요_김재훈 {

    static StringBuilder sb = new StringBuilder();
    static String underbar = ""; // 재귀함수 내에서 사용해야 하므로 정적 변수 지정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 재귀 횟수 N

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        function(n);
        System.out.println(sb);
    }

    static void function(int n) {
        String line = underbar; // 함수 내에서 사용할 변수

        if (n == 0) {
            sb.append(line).append("\"재귀함수가 뭔가요?\"\n")
                    .append(line).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
                    .append(line).append("라고 답변하였지.\n");

            return;
        }

        sb.append(line).append("\"재귀함수가 뭔가요?\"\n")
                .append(line).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                .append(line).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                .append(line).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        underbar += "_".repeat(4); // 정적 변수 활용

        function(n - 1);
        sb.append(line).append("라고 답변하였지.\n");
    }
}
