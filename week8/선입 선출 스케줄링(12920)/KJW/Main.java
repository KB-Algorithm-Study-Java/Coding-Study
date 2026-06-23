class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int left = 0, right = -1;
        for(int core : cores) right = Math.max(right, core);
        right *= n;

        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = cores.length;
            for(int core : cores) cnt += mid / core;

            if(cnt < n) left = mid + 1;
            else right = mid - 1;
        }

        int cnt = cores.length;
        for(int core : cores) cnt += (left - 1) / core;
        int idx = n - cnt;

        for(int i = 0; i < cores.length; i++) {
            if(left % cores[i] == 0) {
                idx--;
                if(idx == 0) answer = i+1;
            }
        }
        return answer;
    }
}