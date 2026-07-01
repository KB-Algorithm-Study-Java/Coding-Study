class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) {
            return n;
        }

        // 코어들은 시작전에 작업을 하나씩 가져가니 미리 빼기
        n -= cores.length;

        // 작업 처리 시간이 가장 오래 걸리는 코어 찾기
        long maxCore = 0;
        for(int core : cores) {
            if(core > maxCore) {
                maxCore = core;
            }
        }

        long left = 1;
        long right = maxCore * n;
        long time = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;

            long capacity = 0;
            for(int core : cores) {
                capacity += mid/core;
            }

            if(capacity >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long worksDone = 0;
        for (int core : cores) {
            worksDone += (time - 1) / core;
        }

        for (int i = 0; i < cores.length; i++) {
            if (time % cores[i] == 0) {
                worksDone++;
                if (worksDone == n) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}