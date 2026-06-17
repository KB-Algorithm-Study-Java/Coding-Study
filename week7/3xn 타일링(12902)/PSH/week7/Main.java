package week7;

class Solution {
    public static long solution(int n) {
        if (n == 0) return 1;
        if (n % 2 != 0) return 0;

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            // dp[i]=4*dp[i-2]-dp[i-4]
            dp[i]=(4*dp[i-2]-dp[i-4]+1000000007 )% 1000000007;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}