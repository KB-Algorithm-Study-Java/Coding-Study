package PSH;
import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    // 왼쪽이 대각 움직일때
// [1,1][0,0]
// [-1,1][0,0]
// 오른쪽이 대각 움직일때
// [0,0][1,-1]
// [0,0][-1,-1]
    // 0,1,0,1
    // 0,-1,0,-1
    // 1,0,1,0
    // -1,0,-1,0
    static int[][] d = {{1,1,0,0},{-1,1,0,0},{0,0,1,-1},{0,0,-1,-1},{0,1,0,1},{0,-1,0,-1},{1,0,1,0},{-1,0,-1,0}};
    public static int solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        // 현재 Lcr Lcc Rcr Rcc
        queue.add(new int[] {0,0,0,1,0});
        boolean[][][] visited = new boolean[m][n][2]; //0> left 1>right
        visited[0][0][0] = true;
        visited[0][1][1] = true;

        System.out.println(m);
        System.out.println(n);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int dist = cur[4];
            if((cur[0]==m-1&&cur[1]==n-1) || (cur[2]==m-1&&cur[3]==n-1)) return dist;
            System.out.println("dist : "+ dist);
            System.out.println("왼쪽 : "+cur[0]+","+ cur[1]);
            System.out.println("오른쪽 : "+cur[2]+","+ cur[3]);
            for(int i=0;i<8;i++){
                int Lnr = cur[0] + d[i][0];
                int Lnc = cur[1] + d[i][1];
                int Rnr = cur[2] + d[i][2];
                int Rnc = cur[3] + d[i][3];
                if (Lnr >= 0 && Lnr < m && Rnr >= 0 && Rnr < m && Lnc >= 0 && Lnc < n && Rnc >= 0 && Rnc < n) {
                    if(board[Lnr][Lnc]==0 && board[Rnr][Rnc]==0) {
                        if (!visited[Lnr][Lnc][0] || !visited[Rnr][Rnc][1]) {
                            queue.add(new int[]{Lnr, Lnc, Rnr, Rnc, dist + 1});
                            visited[Lnr][Lnc][0] = true;
                            visited[Rnr][Rnc][1] = true;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }
}