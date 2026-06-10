class Solution {
    int[][] boards;
    int[][] dp;
    int answer = 0;
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        boards = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) boards[i][j] = board[i-1][j-1];
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(boards[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                answer = Math.max(dp[i][j], answer);
            }
        }
        return answer * answer;
    }
}