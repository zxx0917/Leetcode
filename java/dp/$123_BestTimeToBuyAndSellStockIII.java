/**
 * DP，每天的股票可以保留、卖出、或买入。第一次买入股票的利润影响第一次卖出股票的利润，第一次卖出股票的利润影响第二次买入股票的利润，
 * 第二次买入股票的利润影响第二次卖出股票的利润，所以最后返回的secondsell就是最终结果
 * firstSell表示第一次不持有股票的最大利润，
 * firstHold表示第一次持有股票的最大利润，
 * secondSell表示第二次不持有股票的最大利润
 * secondHold表示第二次持有股票的最大利润，
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int firstSell = 0, firstHold = -prices[0], secondSell = 0, secondHold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //保留或卖出
            firstSell = Math.max(firstSell, firstHold + prices[i]);
            //保留或第一次买入
            firstHold = Math.max(firstHold, -prices[i]);
            //第二次持有股票可能是第i-1天没有股票今天买入，或者是第i-1天有股票，保留状态
            secondHold = Math.max(secondHold, firstSell - prices[i]);
            //第二次不持有股票可能是第i-1天有股票，今天卖出；或是第i-1天无股票，保留状态
            secondSell = Math.max(secondSell, secondHold + prices[i]);
        }
        return secondSell;
    }
}

public class $123_BestTimeToBuyAndSellStockIII {
}
