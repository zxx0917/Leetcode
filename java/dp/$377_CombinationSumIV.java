/**
 * dp[i]表示目标和为i的正整数组合个数
 * 对于每一个nums[j]，可以构成目标和i，也可以不构成目标和i，对于可以构成目标的nums[j]，dp[i]=dp[i-nums[j]]，如果不构成目标和，则dp[i]=dp[i]
 * 综上，dp[i]=dp[i-nums[j]]+dp[i-nums[k]]+...
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}

public class $377_CombinationSumIV {
}
