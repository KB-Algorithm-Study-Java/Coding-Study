import java.util.*;
class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int[] jr = {2,0,-2,0};
    static int[] jc = {0,2,0,-2};
    public static int solution(int n, int m, int[][] hole) {
        //그리드, bfs, drdc, n,m

        // 그리드 만들기
        int[][] grid = new int[n][m];
        for(int[] h : hole){
            int r = h[0] -1;
            int c = h[1] -1;
            grid[r][c] = 1;
        }
        //bfs
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0,0,0,0}); //r,c,dist,jump
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dist = cur[2];
            int jump = cur[3];
            if(cr==n-1 && cc==m-1){
                if(jump==0) return dist-1;
                return dist;
            }
            //jump 쓰고 성공한 경우
            for(int i=0;i<4;i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                //  next보기
                if(nr>=0&&nc>=0&&nr<n&&nc<m){
                    if(!visited[nr][nc][jump] && grid[nr][nc]== 0){
                        queue.offer(new int[] {nr,nc,dist+1,jump});
                        visited[nr][nc][jump] = true;
                    }
                }
                // 여기서 esle if..?  -> if
                if(jump==0){
                    int nnr = cr + jr[i];
                    int nnc = cc + jc[i];
                    if(nnr>=0&&nnc>=0&&nnr<n&&nnc<m){
                        if(!visited[nnr][nnc][1] && grid[nnr][nnc]==0){
                            queue.offer(new int[] {nnr,nnc,dist+1,1});
                            visited[nnr][nnc][1] = true;
                        }
                    }

                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int hole[][] = {{2,3},{3,3}};
        System.out.println(solution(4,4,hole));
    }
}