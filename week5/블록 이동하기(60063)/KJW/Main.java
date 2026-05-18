import java.util.*;

class Solution {
    int[][] board;
    int n;
    boolean[][][][] visited;
    int[] dir = {-1, 1, 0, 0}, dic = {0, 0, -1, 1}; //상하좌우 0123
    public int BFS(int hr, int hc, int tr, int tc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{hr, hc, tr, tc, 0});
        visited[hr][hc][tr][tc] = true;
        visited[tr][tc][hr][hc] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int sr = cur[0], sc = cur[1];
            int er = cur[2], ec = cur[3];
            int frst = cur[4];

            if((sr == n-1 && sc == n-1) || (er == n-1 && ec == n-1)){
                return frst;
            }
            for(int i = 0; i < 4; i++) {
                int nsr = sr + dir[i];
                int nsc = sc + dic[i];
                int ner = er + dir[i];
                int nec = ec + dic[i];

                if(nsr >= n || nsr < 0 || ner >= n || ner < 0) continue;
                if(nsc >= n || nsc < 0 || nec >= n || nec < 0) continue;
                if(board[nsr][nsc] == 1 || board[ner][nec] == 1) continue;
                if(!visited[nsr][nsc][ner][nec] && !visited[ner][nec][nsr][nsc]) {
                    q.offer(new int[]{nsr, nsc, ner, nec, frst + 1});
                    visited[nsr][nsc][ner][nec] = true;
                    visited[ner][nec][nsr][nsc] = true;
                }
                if(!visited[nsr][nsc][sr][sc] && !visited[sr][sc][nsr][nsc]) {
                    q.offer(new int[]{nsr, nsc, sr, sc, frst + 1});
                    visited[nsr][nsc][sr][sc] = true;
                    visited[sr][sc][nsr][nsc] = true;
                }
                if(!visited[ner][nec][er][ec] && !visited[er][ec][ner][nec]) {
                    q.offer(new int[]{ner, nec, er, ec, frst + 1});
                    visited[ner][nec][er][ec] = true;
                    visited[er][ec][ner][nec] = true;
                }
            }
        }
        return 0;
    }
    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        n = board.length;
        visited = new boolean[n][n][n][n];
        answer = BFS(0,0, 0,1);
        return answer;
    }
}