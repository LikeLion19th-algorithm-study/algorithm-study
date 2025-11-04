# Map의 메서드 (Java 8+)
- `putIfAbsent(K key, V value)`
  - Key가 존재할 경우: Value 변경 없이 기존에 존재하는 Key의 Value를 반환한다.
  - Key가 존재하지 않는 경우: Key에 해당하는 Value를 저장한 후 null을 반환한다.
  - 예시)
    - `Map<String, Integer>`에 `key = "A", value = 5`인 데이터를 `put`한다.
    - `map.putIfAbsent("A", 10)` : Key가 이미 존재하기 때문에 Value의 수정 없이 5를 반환한다.
    - `map.putIfAbsent("B", 5)` : Key가 존재하지 않기 때문에 5를 저장한 후 null을 반환한다.


- `compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
  - Key의 여부와 관계 없이 전달받은 인자를 통해 람다 함수를 적용하고, 결과에 따라 key를 제거하거나, 새로운 value를 저장한다.
  - Key가 존재하지 않을 경우 NPE(NullPointerException)이 발생할 수 있기 때문에 연산을 하기 전 값을 체크해주는 것이 좋다.
  - 예시)
    - `Map<String, Integer>`에 `key = "A", value = 5`, `key = "B", value = 10`인 데이터를 `put`한다.
    - `map.compute("A", (k, v) -> v == null ? 15 : v + 5)` : Key가 A인 Value가 5로 존재하므로, 5를 더한 10으로 저장한다.
    - `map.compute("C", (k, v) -> v == null ? 15 : v + 5)` : Key가 C인 Value는 존재하지 않으므로, 15를 저장한다.


> BiFunction?\
`Function(T, R)`은 매개변수를 하나 가지고, 매개변수와 같거나 다른 타입을 반환할 수 있는데, 여기에 `Bi` 가 붙은 것이다.\
`BiFunction(T, U, R)`은 매개변수를 두 개 가지고, 매개변수와 같거나 다른 타입을 반환할 수 있다.
>

- `computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`
  - Key가 존재할 경우: 아무런 작업을 하지 않고 기존에 존재하는 Key의 Value를 반환한다.
  - Key가 존재하지 않는 경우: 람다식을 적용한 값을 해당 Key에 저장한 후 newValue를 반환한다.
  - 예시)
    - `Map<Integer, String>`에 `key = 1, value = "One"`, `key = 2, value = "Two"`인 데이터를 `put`한다.
    - `map.computeIfAbsent(1, k -> "NewOne")` : Key가 1인 Value는 이미 존재하므로 기존 값인 One을 반환한다.
    - `map.computeIfAbsent(3, k -> "Three")` : Key가 3인 Value는 존재하지 않으므로 Three를 저장 후 반환한다.


- `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
  - Key가 존재할 경우: 람다식을 적용한 값이 null이 아니면 해당 Key에 저장한 후 반환하고, null이면 Key를 제거한 후 null을 반환한다.
  - Key가 존재하지 않는 경우: null을 반환한다.
  - 예시)
    - `Map<String, Integer>`에 `key = "A", value = 100`, `key = "B", value = 200`인 데이터를 `put`한다.
    - `map.computeIfPresent("A", (k, v) -> v + 50)` : Key가 A인 Value는 100이 존재하므로 50을 더한 150을 반환한다.
    - `map.computeIfPresent("B", (k, v) -> null)` : Key가 B인 Value가 null이 되면서 Key를 제거하고 null을 반환한다.
    - `map.computeIfPresent("C", (k, v) -> v + 10)` : Key가 C인 Value가 존재하지 않으므로 null을 반환한다.


- `getOrDefault(Object key, V defaultValue)`
  - Key가 존재할 경우: Key에 존재하는 Value를 반환한다.
  - Key가 존재하지 않는 경우: 두 번째 인자로 설정한 defaultValue를 반환한다.
  - 예시)
    - `Map<String, String>`에 `key = "A", value = "Apple"`인 데이터를 `put`한다.
    - `map.getOrDefault("A", "Default")` : Key가 A인 Value가 존재하므로 그 값인 Apple을 반환한다.
    - `map.getOrDefault("B", "Default")` : Key가 B인 Value가 존재하지 않으므로 Default를 반환한다.
---
# 완주하지 못한 선수
- 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
- 마라톤에 참여한 선수들의 이름이 담긴 배열 `participant`와 완주한 선수들의 이름이 담긴 배열 `completion`이 주어진다.
- 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성한다.
- completion의 길이는 participant의 길이보다 1 작다.
- 참가자 중에는 동명이인이 있을 수 있다.

- 예시
  - `String[] participant = {"leo", "kiki", "eden"};`
  - `String[] completion = {"kiki", "eden"};`


```java
for (String participantName : participant) {
        map.compute(participantName, (k, v) -> v == null ? 1 : v + 1);
    }
```
- participant(참가자) 배열을 순회하면서 key로 조회하고, value가 null일 경우 1, value가 있을 경우 기존 값에 1을 더해준다.
- {"leo": 1, "kiki": 1, "eden": 1}

 
```java
for (String completionName : completion) {
        map.compute(completionName, (k, v) -> v == null ? 0 : v - 1);
    }
```
- completion(완주자) 배열을 순회하면서 key로 조회하고, value가 null일 경우 0, value가 있을 경우 기존 값에서 1을 뺀다.
- {"leo": 1, "kiki": 0, "eden": 0}

```java
for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
    }
    return "";
```
- completion(완주자)의 길이는 participant(참가자)의 길이보다 1 작기 때문에 key를 통해 값을 조회하면 0이 아닌 값은 1개만 남는다. 