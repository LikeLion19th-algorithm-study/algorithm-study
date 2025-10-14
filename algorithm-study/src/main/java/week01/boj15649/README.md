# BOJ 15649

문제) 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- 조건) 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 예) N=4, M=2 : [1,2], [1,3], [1,4], [2,1], [2,3], [2,4], [3,1], [3,2], [3,4], [4,1], [4,2], [4,3]

## 백트래킹
- 시도 -> 실패 -> 되돌아감을 반복하면서 정답을 찾아가는 알고리즘
- 재귀적으로 문제를 해결한다.
  - 재귀 -> 본인을 다시 호출 (예: 팩토리얼)
  ```java
   public class Factorial {
       public static void main(String[] args) {
           System.out.println(factorial(4));
       }
    
       public static int factorial(int n) {
           if (n == 1) return 1;
  
           return n * factorial(n - 1);
       }
   }
    
   /*
   n = 4 -> 4 * factorial(3) ==> 24
       n = 3 -> 3 * factorial(2) ==> 6
           n = 2 -> 2 * factorial(1) ==> 2
               n = 1 -> 1
   */
        
    ```
  
## 수열
- 예제) 1부터 4까지 자연수 중에서 중복 없이 3개를 고른 수열
```
depth  (0)      (1)      (2)  
        1 ────── 2 ────── 3
            │         └── 4 
            │
            ├─── 3 ────── 2
            │         └── 4 
            │     
            └─── 4 ────── 2
                      └── 3
        
        2 ...
```

- `boolean visited[n]` : 방문한 숫자를 알아낸다.
- `int[] arr[m]` : 수열을 배열 형태로 저장
- `int depth` : 몇 번째 수열인지 가르키기 위한 값

```
static void backtracking(int depth) {
        if (depth == arr.length) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
        
# backtracking(0) -> i = 0, visitied[0] = true, arr[0] = 1, backtracking(1)
                  └── ## backtracking(1) -> i = 0, visited[0] 이미 true
                                        -> i = 1, visited[1] = true, arr[1] = 2, backtracking(2)
                                        └── ### backtracking(2) -> i = 0, visited[0] 이미 true
                                                            -> i = 1, visited[1] 이미 true
                                                            -> i = 2, visited[2] = true, arr[2] = 3, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 2, 3] ==> visited[2] = false
                                    
                                                            -> i = 3, visited[3] = true, arr[3] = 4, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 2, 4] ==> visited[3] = false
                                        
                                        -> i = 2, visited[2] = true, arr[2] = 3, backtrakcing(2)
                                        └── ### backtracking(2) -> i = 0, visited[0] 이미 true
                                                            -> i = 1, visited[1] = true, arr[2] = 2, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 3, 2] ==> visited[1] = false
                                    
                                                            -> i = 2, visited[2] 이미 true
                                                            -> i = 3, visited[3] = true, arr[2] = 4, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 3, 4] ==> visited[3] = false
                                        
                                        -> i = 3, visited[3] = true, arr[3] = 4, backtracking(2)
                                        └── ### backtracking(2) -> i = 0, visited[0] 이미 true
                                                            -> i = 1, visited[1] = true, arr[2] = 2, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 4, 2] ==> visited[1] = false
                                    
                                                            -> i = 2, visited[2] = true, arr[2] = 3, backtracking(3)
                                                            └── #### backtracking(3) -> depth == arr.length, [1, 4, 3] ==> visited[2] = false
                                                            
                                                            -> i = 3, visited[3] 이미 true
                  
                  -> i = 1, ...                                        
```