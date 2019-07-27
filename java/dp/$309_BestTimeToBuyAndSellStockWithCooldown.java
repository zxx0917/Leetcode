//sell表示第i天不持有股票的最大利润，hold表示第i天持有股票的最大利润，股票可以保留、买入和卖出
//这里注意有冷冻期，即第i天持有股票的最大利润依靠的是冷冻期前一天的不持有股票的最大利润
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int sell = 0, hold = -prices[0], preDay = sell;
        //DP
        for (int i = 1; i < prices.length; i++) {
            int tmp = sell;
            //保留或卖出第i-1天的股票
            sell = Math.max(sell, hold + prices[i]);
            //保留或经历冷冻期，通过第i-2天不持有股票的利润买入股票
            hold = Math.max(hold, preDay - prices[i]);
            //更新冷冻期前一天的利润
            preDay = tmp;

        }
        return sell;
    }
}
public class $309_BestTimeToBuyAndSellStockWithCooldown {
}
