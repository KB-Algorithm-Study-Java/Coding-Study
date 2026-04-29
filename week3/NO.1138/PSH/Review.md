[백준 1138번 - 한줄로서기](https://www.acmicpc.net/problem/1138)

### 접근 방식

```
4(왼쪽에 0) index 0에 넣음
4->3 (왼쪽에 1) index 1

2(왼쪽에 1명)
4->2->3 (index 1에 넣음)

왼쪽에 큰 사람 arr[i]명 있게 하려면
index = arr[i]

```
### method 풀이

1. add를 위해 linkedlist로 list를 생성함.
2. for문을 감소 연산을 하면서 순회 (큰번호 값을 먼저 넣기 위해서)
3. list에 arr가 가지고 있는 값을 인덱스 자체로 추가한다.
---