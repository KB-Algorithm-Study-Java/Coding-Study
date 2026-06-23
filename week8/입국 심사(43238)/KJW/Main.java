class Solution {
    int n;
    int[] times;
    public long binary(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for(int i : times) cnt += mid / i;
            if(cnt >= n) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;

        long Max = -1;
        for(int i : times) Max = Math.max(Max, i);
        return binary(1, Max * n);
    }
}