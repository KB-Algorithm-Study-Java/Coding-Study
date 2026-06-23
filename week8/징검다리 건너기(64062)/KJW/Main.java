class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int left = 1, right = -1;
        for(int stone : stones) right = Math.max(right, stone);

        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int stone : stones) {
                if(stone - mid <= 0) {
                    cnt++;
                    if(cnt == k) break;
                }
                else cnt = 0;
            }
            if(cnt < k) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}