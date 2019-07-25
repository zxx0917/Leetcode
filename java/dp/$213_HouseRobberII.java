//因为第一个房子和最后一个房子不同同时偷，所以可以分为两种情况来讨论：1.去除最后一个房子，表示最后一个房子不偷；2.去除第一个房子，表示第一个房子不能偷
//对这两种情况进行动态规划，最后求出两种情况的最大值即可。
//对于每个房子，有偷和不偷两种状态，所以使用dp[i][0]和dp[i][1]分别表示不偷第i号房的总金额和偷第i号房的总金额
//对于第1座房子：dp[0][0] = 0,dp[0][1] = nums[0]
//对于第i座房子：
// 1、不偷i号房的最大金额为第i-1号房偷来的最大值，因为i-1号房可偷可不偷，dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
// 2、偷i号房的最大金额为不偷第i-1号房的总金额+i号房的金额，dp[i][1] = dp[i-1][0]+nums[i]
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int res = 0;
        //最后一个房子不偷
        int[][] dp1 = new int[n][2];
        dp1[0][0] = 0;
        dp1[0][1] = nums[0];
        //第一个房子不偷
        int[][] dp2 = new int[n][2];
        dp2[1][0] = 0;
        dp2[1][1] = nums[1];


        for (int i = 1; i < n; i++) {
            //最后一个房子不偷
            if (i != n - 1) {
                dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
                dp1[i][1] = dp1[i - 1][0] + nums[i];
            }
            //第一个房子不偷
            if (i != 1) {
                dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
                dp2[i][1] = dp2[i - 1][0] + nums[i];
            }
        }
        return Math.max(Math.max(dp1[n - 2][0], dp1[n - 2][1]), Math.max(dp2[n - 1][0], dp2[n - 1][1]));
    }
}

public class $213_HouseRobberII {
}
