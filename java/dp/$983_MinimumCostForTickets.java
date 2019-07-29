/**
 * dp[i]表示第0天~i天出行的最小消费，如果需要出行，判断是日票便宜还是一周前买周票便宜还是一个月前买月票便宜，所以dp[i]=Math.min(dp[i-1]+costs[0],dp[i-7]+costs[1],dp[i-30]+cost[2])
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0) return 0;
        //表示第1天到第365天出现的最小消费
        int[] dp = new int[366];
        dp[0] = 0;
        int count = 0;
        for (int i = 1; i <= 365; i++) {
            if (count >= days.length) break;
            if (days[count] != i) {
                //今天不是出行日，今天的花费就是昨天的花费
                dp[i] = dp[i - 1];
            } else {
                //今天是出行日
                count++;
                dp[i] = Math.min(Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1]), dp[Math.max(0, i - 30)] + costs[2]);
            }
        }
        //返回最后一次出行的最小消费
        return dp[days[days.length - 1]];
    }
}

public class $983_MinimumCostForTickets {
}
