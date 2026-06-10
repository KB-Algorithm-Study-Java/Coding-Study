import java.util.*;
class Solution {
    long[] dp;
    public long solution(int n) {
        if(n % 2 != 0) return 0;
        dp = new long[n+1];
        dp[0] = 1;

        if(n >= 2) dp[2] = 3;

        for(int i = 4; i <= n; i++) {
            if(i % 2 != 0) continue;

            long sum = 0;
            for(int j = i - 4; j >= 0; j-=2) sum = (sum + dp[j] * 2) % 1000000007;
            dp[i] = (3 * dp[i-2] + sum) % 1000000007;
        }
        return dp[n];
    }
}