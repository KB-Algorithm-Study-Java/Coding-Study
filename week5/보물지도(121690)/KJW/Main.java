import java.util.*;
class Solution {
    int m, n;
    int[][] map;
    boolean[][][] visited;
    int[] dir = {-1, 1, 0, 0}, dic = {0, 0, -1, 1};
    public int BFS(int sr, int sc) {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(sr, sc, false, 0));
        visited[sr][sc][0] = true;

        while(!q.isEmpty()) {
            State cur = q.poll();
            int fr = cur.r;
            int fc = cur.c;
            boolean fbroke = cur.broke;
            int frst = cur.rst;

            int broken = fbroke ? 1 : 0;

            if(fr == m && fc == n) return frst;

            for(int i = 0; i < 4; i ++) {
                int nr = fr + dir[i];
                int nc = fc + dic[i];
                if(nr > m || nr < 1 || nc > n || nc < 1) continue;
                if(map[nr][nc] == 1 && !visited[nr][nc][broken]) {
                    q.offer(new State(nr, nc, fbroke, frst + 1));
                    visited[nr][nc][broken] = true;
                }

                if(!fbroke) {
                    nr = fr + dir[i] * 2;
                    nc = fc + dic[i] * 2;
                    if(nr > m || nr < 1 || nc > n || nc < 1) continue;
                    if(map[nr][nc] == 0) continue;
                    if(visited[nr][nc][1]) continue;
                    q.offer(new State(nr, nc, true, frst+1));
                    visited[nr][nc][1] = true;
                }
            }
        }
        return -1;
    }
    public int solution(int n, int m, int[][] hole) {
        this.m = m;
        this.n = n;
        int answer = 0;
        map = new int[m+1][n+1];
        visited = new boolean[m+1][n+1][2];

        for(int[] i : map) Arrays.fill(i, 1);
        for(int[] i : hole) map[i[1]][i[0]] = 0;
        return BFS(1, 1);
    }
    class State {
        int r, c, rst;
        boolean broke;

        State(int r, int c, boolean broke, int rst) {
            this.r = r;
            this.c = c;
            this.broke = broke;
            this.rst = rst;
        }
    }
}