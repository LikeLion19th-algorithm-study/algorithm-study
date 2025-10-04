package week02.pgs42577;

import java.util.Arrays;

/**
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * <p>
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * <p>
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 * <p>
 * 정확성: 83.3 / 효율성: 16.7
 * Hash를 사용한 풀이법은 찾지 못했다.
 */
public class 전화번호목록_김재훈 {
    public static boolean solution1(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book); // 짧은 문자가 접두어가 될 가능성이 높으므로 정렬을 먼저 한다.

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        System.out.println(solution1(phone_book1));
        System.out.println(solution1(phone_book2));
        System.out.println(solution1(phone_book3));
    }
}
