import java.util.*;
class Solution {
    int n;
    int answer = 0;
    boolean[] used;
    int[] row;
    public void Queen(int rst) {
        if(rst == n) {
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(used[i]) continue;
            boolean valid = true;
            for(int t = 0; t < rst; t++) {
                if(Math.abs(row[t] - i) == rst - t) {
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            used[i] = true;
            row[rst] = i;
            Queen(rst + 1);
            used[i] = false;
        }
    }
    public int solution(int n) {
        this.n = n;
        used = new boolean[n];
        row = new int[n];

        Queen(0);
        return answer;
    }
}