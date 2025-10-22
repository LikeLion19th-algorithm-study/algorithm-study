package week02.boj1764;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
 * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
 * 듣보잡의 수와 그 명단을 사전순으로 출력한다.
 *
 * 시간: 272ms / 메모리: 26708KB
 * - TreeSet이 아닌 List로 할 경우 -> 시간: 284ms / 메모리: 26060KB
 */
public class 듣보잡_정다희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        Set<String> result = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            String nm = br.readLine();
            if(set.contains(nm)) {
                result.add(nm);
            }
        }

        sb.append(result.size()).append("\n");
        for (String r : result) {
            sb.append(r).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
