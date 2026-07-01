class Solution {
    public long solution(int n, int[] times) {
        // 최소 심사 시간
        long left = 1;
        // 최대 심사 시간 - 가장 느린 심사 시간 * 인원 수
        long right = (long)times[times.length-1] * n;
        long answer = right;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for(int time : times) {
                count += mid / time;
                if(count >= n) {
                    break;
                }
            }

            if(count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return answer;
    }
}