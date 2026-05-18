import java.util.*;

class Solution {
    int n, m, x, y, r, c, k;
    String answer = "";
    char[] rst;
    int[] dir = {1, 0, 0, -1}, dic = {0, -1, 1, 0};
    char[] way = {'d', 'l', 'r', 'u'};
    boolean valid = false;
    public void DFS(int sr, int sc, int depth) {
        if(valid) return;
        if(depth == k) {
            if(sr == r && sc == c) {
                String rt = new String(rst);
                answer = rt;
                valid = true;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nr = sr + dir[i];
            int nc = sc + dic[i];

            if(nr > n || nr < 1 || nc > m || nc < 1) continue;
            if(k - depth - 1 < Math.abs(nr - r) + Math.abs(nc - c)) continue;

            rst[depth] = way[i];
            DFS(nr, nc, depth + 1);
        }
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;

        int dist = Math.abs(r - x) + Math.abs(c - y);
        if(dist > k || (k - dist) % 2 != 0) return "impossible";
        rst = new char[k];
        DFS(x, y, 0);

        if(answer == "") return "impossible";
        return answer;
    }
}