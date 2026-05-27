import java.util.*;

class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        int[][] maps = new int[n][m];

        for(int[] location : hole) {
            int r = location[0] - 1;
            int c = location[1] - 1;

            maps[r][c] = 1;
        }

        return bfs(n, m, maps);
    }

    int bfs(int n, int m, int[][] maps) {
        // code 설계
        // 초기 세팅
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][2];

        // 시작 노드 설정
        q.offer(new int[]{0, 0, 0, 1});
        // 방문 상태만 true
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int distance = cur[2];
            int fly = cur[3];

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    //마법을 안 쓴 경우
                    if(maps[nr][nc] == 0) {
                        if(nr == n - 1 && nc == m - 1) {
                            return distance + 1;
                        }

                        if(fly == 1 && !visited[nr][nc][0]) {
                            q.offer(new int[]{nr, nc, distance + 1, fly});
                            visited[nr][nc][0] = true;
                        } else if(fly == 0 && !visited[nr][nc][1]) {
                            q.offer(new int[]{nr, nc, distance + 1, fly});
                            visited[nr][nc][1] = true;
                        }

                    }

                    //마법을 쓴 경우
                    if(!visited[nr][nc][0] && maps[nr][nc] == 1 && fly == 1) {
                        int jr = nr + dr[i];
                        int jc = nc + dc[i];

                        if(jr >= 0 && jr < n && jc >= 0 && jc < m && maps[jr][jc] == 0) {
                            if(jr == n - 1 && jc == m -1) {
                                return distance + 1;
                            }

                            q.offer(new int[]{jr, jc, distance + 1, 0});
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}