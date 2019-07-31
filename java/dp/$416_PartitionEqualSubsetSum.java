
/**
 * 求出数组的总和，然后判断nums中是否存在子序列使得和为sum/2
 * dp[i][j]为在0~i的元素中是否可以取数使其和为sum/2
 * 对于i元素，可以取或者不取，当不取i元素是，dp[i][j]=dp[i-1][j]；取i元素时，dp[i][j]=dp[i-1][j-nums[i]]，即判断在0~i-1元素中，是否可以使其和为j-nums[i]
 * 所以状态转移方程为：dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
 * 最后判断dp[nums.length-1][sum/2]即可
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length, sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[len][sum + 1];
        //初始化，对于第一个元素
        for (int i = 1; i <= sum; i++) {
            if (nums[0] == i) dp[0][i] = true;
        }
        //DP
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][sum];
    }
}


//优化为一维数组：
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //为奇数，直接返回
        if ((sum & 1) == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        //初始化
        for (int i = 1; i <= sum; i++) {
            if (nums[0] == i) {
                dp[i] = true;
            }
        }

        //DP
        for (int i = 1; i < len; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}

public class $416_PartitionEqualSubsetSum {
}
