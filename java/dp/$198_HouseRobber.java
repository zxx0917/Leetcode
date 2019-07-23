//对于当前房屋有两种情况：偷当前房屋和不偷当前房屋，所以创建一个dp[nums.length][2]，
//dp[i][0]表示不偷i号屋，dp[i][1]表示偷i号屋。对于dp[i][0]，因为题目要求相邻的屋子不能偷，
// 所以dp[i][0]有两种偷取方式：偷相邻屋子或不偷相邻屋子，取这两者最大值即可；而对于dp[i][1]，因为i屋一定偷取，所以i-1屋一定不能偷
//状态转移方程为：dp[n][0] = Math.max(dp[n-1][0],dp[n-1][1])，dp[n][1]=dp[n-1][0]+nums[n]
//最后求dp[n][0]/dp[n][1]的最大值
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}

public class $198_HouseRobber {
}
