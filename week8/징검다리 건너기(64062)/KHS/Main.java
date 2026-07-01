class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200_000_000;

        while(left <= right) {
            // 중간값 구하기
            int mid = (left + right) / 2;

            if(isPossible(mid, stones, k)) {
                // 최대값 범위 갱신
                answer = mid;
                // 최소값 범위 늘리기
                left = mid + 1;
            }  else {
                // 최대값 범위 줄이기
                right = mid - 1;
            }
        }
        return answer;
    }

    boolean isPossible(int mid, int[] stones, int k) {
        int count = 0;
        for(int stone : stones) {
            if(mid > stone) {
                count++;
            } else {
                count = 0;
            }

            if(count == k) return false;
        }

        return true;
    }
}
