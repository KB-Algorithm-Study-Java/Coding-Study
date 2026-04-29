> [백준 2258번 - 정육점](https://www.acmicpc.net/problem/2258)

### 접근 방식

```
입력
N,M
Weight, price

Map(무게, 가격) 

일단 가장 비싼걸 골라 -> 무게합구해 -> opt 비용으로 초기화


1.그 다음으로 비싼걸 골랐을때 -> 무게합이 M보다 작으면 안돼 -> 여기서 끝
2. ""                  -> 무게합이 M보다 크면 -> 이 가격으로 opt 비용 업데이트 


총합
10-자기자신 < M  break

```
### method 풀이

buffer에 입력받기
1. stringtokenizer 객체를 2개 생성
   - 처음에는 N,M을 입력받음
   - 두번쨰는 N줄 만큼 입력을 받을건데, weight이랑 price를 map에 넣을거임
2. treemap을 생성 -> key,value로 넣으면서 자동정렬이 필요했음
    - 내림차순 정렬 : reverse치니까 자동완성 (Comparator.reverseOrder())

최적해 찾기
1. optimization 값을 -1로 초기화시켜둠.
2. 내림차순 정렬된 tree를 순회하면서 가장 높은 가격이 일단 opt가 됨.
3. total무게값에서 지금 무게를 뺀 값이 M보다 작으면 break한다.
4. total무게값에서 지금 무게를 뺀 값이 M보다 크면 아직 최적해가 남아있을 수 있다. 
5. 다음 순회에서 opt 가격보다 작은데 total무게값에서 

---
### 후기