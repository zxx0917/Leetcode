/**
 * 动态规划，dp[i]表示第i个数的最大乘积，dp[i]应该为dp[j]*(i-j)的最大值，j属于[1,i-1]，同时还需要比较j*(i-j)的最大值，如6的最大值为3*(6-3)
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }
}

public class $343_IntegerBreak {
}
