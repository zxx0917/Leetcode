/**
 * 股票有三种状态，可以抛，可以卖，可以保持不动，设定dp[i][0]作为第i天不持有股票的最大利润，dp[i][1]表示第i天持有股票的最大利润
 * 对于dp[i][0]，第i天没有股票是因为：1.第i-1天没有股票，第i天保持了这种情况；2.第i-1天持有股票，但是第i天卖出
 * 所以状态转移方程为：dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
 * 对于dp[i][1]，第i天持有股票是因为：1.第i-1天有股票，第i天保持不变；2.第i-1天没有股票，第i天买入了股票
 * 所以状态转移方程为：dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 * 这里的边界条件如下：第一天没有股票，则利润为0，即dp[0][0] = 0; 第一天买入了股票，利润为-prices[0]，即dp[0][1] = -prices[0];
 * 简化一下，因为第i天的结果是从第i-1天得来，所以我们可以只是用两个变量，sell表示不持有股票的最大利润，hold表示持有股票的最大利润
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length, sell = 0, hold = -prices[0];
        for (int i = 1; i < n; i++) {
            //保持不变或抛出股票
            sell = Math.max(sell, hold + prices[i] - fee);
            //保持不变或购买股票
            hold = Math.max(hold, sell - prices[i]);
        }
        return Math.max(hold, sell);
    }
}

public class $714_BestTimeToBuyAndSellStockWithTransactionFee {
}
