package week02.boj17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 저장된 사이트 주소의 수 N(1 ≤ N ≤ 100,000)과 비밀번호를 찾으려는 사이트 주소의 수 M(1 ≤ M ≤ 100,000)
 * 두번째 줄부터 N개의 줄에 걸쳐 각 줄에 사이트 주소와 비밀번호가 공백으로 구분되어 주어진다.
 * 사이트 주소는 알파벳 소문자, 알파벳 대문자, 대시('-'), 마침표('.')로 이루어져 있고, 중복되지 않는다.
 * <p>
 * 시간: 564ms / 메모리: 62056KB
 */
public class 비밀번호찾기_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken()); // 저장하는 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수

        // 사이트와 비밀번호 저장
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pwd = st.nextToken();
            map.put(site, pwd);
        }

        // 사이트와 비밀번호 찾기
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(map.getOrDefault(st.nextToken(), "")).append("\n");
        }
        System.out.println(sb);
    }
}
