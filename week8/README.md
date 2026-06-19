# 📌 8주차 - 이분 탐색 (Binary Search)

### 이번주의 문제

[**입국 심사**](https://school.programmers.co.kr/learn/courses/30/lessons/43238)<br/>
[**징검다리 건너기**](https://school.programmers.co.kr/learn/courses/30/lessons/64062)<br/>
[**선입 선출 스케줄링**](https://school.programmers.co.kr/learn/courses/30/lessons/12920)

---

# 📚 이분 탐색 (Binary Search)

이분 탐색은 **정렬된 데이터에서 원하는 값을 빠르게 찾기 위해 탐색 범위를 절반씩 줄여 나가는 알고리즘**이다.

매 탐색마다 탐색 범위가 절반으로 감소하므로 매우 빠르게 답을 찾을 수 있다.

* Binary Search
* 이진 탐색
* 탐색 범위 절반 감소
* 정렬된 데이터 활용
* O(logN)

👉 핵심: **"탐색 범위를 절반씩 줄인다."**

---

## 🛠️ 이분 탐색 핵심 요소

| 개념    | 설명              |
| ----- | --------------- |
| 정렬    | 데이터가 정렬되어 있어야 함 |
| 탐색 범위 | left ~ right    |
| 중간값   | mid 계산          |
| 범위 축소 | 조건에 따라 좌우 이동    |
| 시간복잡도 | O(logN)         |

---

## 📌 이분 탐색 동작 원리

예시)

```text
1 3 5 7 9 11 13

찾는 값 : 9

mid = 7
9 > 7

오른쪽 탐색

9 11 13

mid = 11
9 < 11

왼쪽 탐색

9

정답 발견
```

---

# 🔍 기본 이분 탐색

정렬된 배열에서 특정 값을 찾는 가장 기본적인 형태이다.

### 예시

```java
int left = 0;
int right = arr.length - 1;

while (left <= right) {
    int mid = (left + right) / 2;

    if (arr[mid] == target) {
        return mid;
    }

    if (arr[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

👉 핵심: **"mid를 기준으로 탐색 범위를 줄인다."**

---

# 📌 Lower Bound

찾고자 하는 값 이상이 처음 나타나는 위치를 찾는다.

### 예시

```java
while (left < right) {
    int mid = (left + right) / 2;

    if (arr[mid] >= target) {
        right = mid;
    } else {
        left = mid + 1;
    }
}
```

### 결과

```text
배열 : [1, 2, 2, 2, 3]

target = 2

결과 위치 : 1
```

👉 핵심: **"target 이상이 처음 등장하는 위치"**

---

# 📌 Upper Bound

찾고자 하는 값을 초과하는 값이 처음 나타나는 위치를 찾는다.

### 예시

```java
while (left < right) {
    int mid = (left + right) / 2;

    if (arr[mid] > target) {
        right = mid;
    } else {
        left = mid + 1;
    }
}
```

### 결과

```text
배열 : [1, 2, 2, 2, 3]

target = 2

결과 위치 : 4
```

👉 핵심: **"target 초과가 처음 등장하는 위치"**

---

# 📌 파라메트릭 서치 (Parametric Search)

최적화 문제를 이분 탐색으로 해결하는 기법이다.

답 자체를 탐색하는 것이 아니라

**"이 값이 가능한가?"**

를 기준으로 탐색한다.

---

## 예시

```text
징검다리 건너기

사람 수 = x

x명이 건널 수 있는가?
```

가능하면 더 큰 값 탐색

불가능하면 더 작은 값 탐색

---

### 기본 형태

```java
while (left <= right) {
    int mid = (left + right) / 2;

    if (can(mid)) {
        answer = mid;
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

👉 핵심: **"정답을 맞추는 것이 아니라 가능 여부를 판별한다."**

---

# ⏱️ 시간복잡도

| 탐색 방법 | 시간복잡도   |
| ----- | ------- |
| 선형 탐색 | O(N)    |
| 이분 탐색 | O(logN) |

예시)

```text
N = 1,000,000

선형 탐색
→ 최대 1,000,000번

이분 탐색
→ 약 20번
```

---

# ⚠️ 이분 탐색 문제에서 중요하게 볼 것

| 체크 포인트            | 설명             |
| ----------------- | -------------- |
| 정렬 여부             | 정렬된 상태인지 확인    |
| 탐색 범위             | left, right 설정 |
| mid 계산            | 중간값 계산         |
| 조건 판단             | 어느 범위를 버릴지 결정  |
| Lower Bound       | 이상이 처음 등장      |
| Upper Bound       | 초과가 처음 등장      |
| Parametric Search | 정답 범위를 탐색      |

---

# 💡 자주 나오는 이분 탐색 유형

| 유형                | 예시            |
| ----------------- | ------------- |
| 값 찾기              | Binary Search |
| Lower Bound       | 첫 등장 위치       |
| Upper Bound       | 마지막 등장 위치     |
| Parametric Search | 입국심사          |
| 최댓값 탐색            | 징검다리 건너기      |
| 최솟값 탐색            | 공유기 설치        |

---

# 💡 정리

| 개념                | 핵심 특징           |
| ----------------- | --------------- |
| Binary Search     | 탐색 범위 절반 감소     |
| Lower Bound       | target 이상 최초 위치 |
| Upper Bound       | target 초과 최초 위치 |
| Parametric Search | 가능 여부로 탐색       |
| 시간복잡도             | O(logN)         |

### 이번 주 핵심

> 이분 탐색은 "탐색 범위를 절반씩 줄여 빠르게 답을 찾는 방법"이다.
>
> 단순 값 탐색뿐만 아니라 Lower Bound, Upper Bound, Parametric Search까지 익히는 것이 이번 주 목표이다.
