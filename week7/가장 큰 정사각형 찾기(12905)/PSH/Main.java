package week7.가;

class Solution {
    //
    public static int solution(int [][]board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];
        int max=0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = board[i][0];
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = board[0][j];
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(board[i][j]==1 ){
                    // 현재위치의 왼,위,왼위 중 dp값이 가장 작은걸 선택해야햐난다.
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
}