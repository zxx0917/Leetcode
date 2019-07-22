//对于第n个元素，具有最大和的连续子数组的最大值为dp[n] = Math.max(nums[n],dp[n-1]+nums[n])，即要不当前元素是最大和的一部分，要不自己就是最大和
//遍历整个数组，每次求出最大和，并保存在结果遍历中
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = -1, res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res,sum);
        }
        return res;
    }
}

public class $53_MaximumSubarray {
}
