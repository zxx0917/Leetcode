import java.util.Arrays;

/**
 * dp[j]表示达到金额j的最小硬币个数，有两种情况，硬币或者不取
 * dp[j]=Math.min(dp[j],dp[j-coins[i]]+1)，其中coins[i] < j
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0) return 0;
        int[] dp = new int[amount + 1];
        //初始化
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int j = 0;j < len;j++) {
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

public class $322_CoinChange {
}
