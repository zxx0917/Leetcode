import java.util.Arrays;


/**
 * dp[i]表示凑成金额i需要的最少硬币数，对于每个硬币，可以取也可以不取，
 * 如果取的话，dp[i]=dp[i-coin]+1，如果不取，最少硬币数不变，dp[i]=dp[i]，所以dp[i]=Math.min(dp[i],dp[i-coin]+1)
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
