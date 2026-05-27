import java.util.*;

class Solution {
    // d l r u
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, -1, 1, 0};
    String[] disStr = {"d", "l", "r", "u"};
    int n, m, r, c, k;
    String answer = null;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r-1;
        this.c = c-1;
        this.k = k;

        x = x - 1;
        y = y - 1;

        backtract(new StringBuilder(), 0, x, y);

        return answer;
    }

    void backtract(StringBuilder cur, int distance, int x, int y) {
        if(answer != null) {
            return;
        }

        int manhattan = Math.abs(x - r) + Math.abs(y - c);
        int rem = k - distance;

        if(manhattan > rem || (rem - manhattan) %2 != 0) {
            answer = "impossible";
            return;
        }

        if(distance == k) {
            answer = cur.toString();
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                cur.append(disStr[i]);
                backtract(cur, distance + 1, nr, nc);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
        return;
    }
}