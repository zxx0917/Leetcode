/**
 * 动态规划，dp[i]表示组成i的完全平方数的最小值。要求最小值的话一定要包括完全平方数，所以对于dp[i]，dp[i] = min(dp[i-1*1]+dp[1*1],dp[i-2*2]+dp[2*2],dp[i-3*3]+dp[3*3]...)
 * 可以看出在里面嵌套一层循环即可得到结果，因为dp[完全平方数]=1，所以dp[i] = min(dp[i-1*1]+1,dp[i-2*2]+1,dp[i-3*3]+1...)
 */
class Solution {
    public int numSquares(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //最小值一定要有一个完全平方数
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    min = 1;
                    break;
                }
                min = Math.min(min, 1 + dp[i - j * j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

public class $279_PerfectSquares {
}
