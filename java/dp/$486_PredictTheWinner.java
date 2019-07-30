/**
 * dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数，最后返回dp[0][nums.length-1]是否大于0即可
 * 对于dp[i][j]，如果先手拿了nums[i]，则另一位玩家比先手多dp[i+1][j]，dp[i][j] = nums[i]-dp[i+1][j]，
 * 如果先手拿了nums[j]，则另一位玩家比先手多dp[i][j-1]，dp[i][j] = nums[j]-dp[i][j-1]
 * 综上，dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
 * 当i=j时，先手一定赢，比另一位玩家多dp[i][j]=nums[i]
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        //DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}

public class $486_PredictTheWinner {
}
