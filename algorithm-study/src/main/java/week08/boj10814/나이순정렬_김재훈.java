package week08.boj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 정렬
 * 메모리: 54548KB | 시간: 668ms
 */
public class 나이순정렬_김재훈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 회원의 수 N

        List<Member> members = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }

        Collections.sort(members);
        members.forEach(member -> sb.append(member).append("\n"));
        System.out.println(sb);
    }
}

class Member implements Comparable<Member> {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        return this.age - o.age; // 나이가 적은 순 정렬
    }

    @Override
    public String toString() {
        return age + " " + name; // 출력 형태 맞추기
    }
}
