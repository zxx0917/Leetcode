/**
 * 题目可以理解为从数组中选出两个子集p和n，Sum(p) - Sum(n) = target;
 * 我们可以推导出：Sum(p) + sum(p) = sum(n) + target + sum(p) => sum(p) = (target+sum)/2
 * 所以可以转换为0-1背包问题：从nums数组中找出N个数，使得它们的和为(target+sum)/2，即背包空间为(target+sum)/2
 * dp[i]表示数组中有多少个子集使得目标数为i, dp[i]=dp[i-nums[j]]+dp[i]
 * 最后返回dp[(target+sum)/2]
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        //求和
        int sum = 0;
        for (int num : nums) sum += num;
        //是奇数则不成立
        if (sum < target || ((target + sum) & 1) == 1) return 0;
        sum = (target + sum) / 2;
        int[] dp = new int[sum + 1];
        //初始化，和为0则一个都不选
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            //复用数组
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j - nums[i]] + dp[j];
            }
        }
        return dp[sum];
    }
}

public class $494_TargetSum {
}
