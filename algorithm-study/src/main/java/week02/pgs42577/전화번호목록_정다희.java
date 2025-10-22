package week02.pgs42577;

import java.util.Arrays;

/**
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성
 * */
public class 전화번호목록_정다희 {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;

        // Hash 문제라서 Hash를 이용하려 풀어보려 했으나 풀이를 찾기 어려워 일단 pass함
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        전화번호목록_정다희 s = new 전화번호목록_정다희();
        System.out.println(s.solution(phone_book));
    }
}
