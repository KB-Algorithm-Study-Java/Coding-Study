import java.util.*;

class Solution {
    final int[] dr = {0, 1, 0, -1};
    final int[] dc = {1, 0, -1, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < answer.length; i++) {
            if(check(places[i])) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    boolean check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(r, c, place)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean bfs(int r, int c, String[] place) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{ r, c, 0 });
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int distance = cur[2];
            if (distance >= 2) continue;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && place[nr].charAt(nc) != 'X') {
                    if (!visited[nr][nc]) {
                        if (place[nr].charAt(nc) == 'P') return false;
                        queue.add(new int[]{ nr, nc, distance + 1 });
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return true;
    }
}