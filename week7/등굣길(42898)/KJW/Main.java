class Solution {
    int n, m;
    int[][] road;
    int[][] dp;
    int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        this.n = n;
        this.m = m;
        road = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int[] i : puddles) road[i[1]][i[0]] = 1;

        dp[1][1] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(road[i][j] == 1) continue;
                if(i == 1 && j == 1) continue;
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        return dp[n][m];
    }
}