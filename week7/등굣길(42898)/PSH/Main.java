package week7.등굣길;
class Solution {
    public static int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n][m];
        boolean[][] hole = new boolean[n][m];

        for (int[] p : puddles) {
            hole[p[1]-1][p[0]-1] = true;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(i==0&&j==0) continue;

                if (hole[i][j]) {
                    continue;
                }
                //오른쪽으로 갈수있으면
                // 일반식
                if(j>0) dp[i][j] = (dp[i][j]+dp[i][j-1])% 1000000007;
                //아래로 갈수있으면..
                if(i>0) dp[i][j] = (dp[i][j]+dp[i-1][j])% 1000000007;
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] puddles = {{2,2}};
        System.out.println(solution(4,3,puddles));
    }
}