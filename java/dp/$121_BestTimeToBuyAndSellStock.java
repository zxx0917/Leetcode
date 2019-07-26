//DP，使用sell表示不持有股票的最大利润，hold表示持有股票的最大利润
//对于第i天不持有股票的最大利润，可以保持第i-1的不持有股票的最大利润不变，也可以卖出第i-1的股票
//对于第i天的持有股票的最大利润，可以保持第i-1天的持有股票最大利润，也可以买入当前的股票
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int sell = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return Math.max(sell, hold);
    }
}

public class $121_BestTimeToBuyAndSellStock {
}
