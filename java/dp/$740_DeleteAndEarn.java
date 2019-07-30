/**
 * 对于nums[i]，nums[i]+1和nums[i]-1的数不能拿，我们可以将数组转换为在nums[i]时所有的点数和，
 * 如[1,3,4]，转换为[0,1,0,3,4]，当获取i时不能获取相邻的两个元素，转换为打家劫舍问题
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] newArr = new int[10001];
        for (int num : nums) {
            newArr[num] += num;
        }
        //初始化，dp[i]到第i个元素的最大点数，如果不拿第i个元素，当前点数为dp[i-1]，如果拿第i个元素，则当前点数为dp[i-2]+nums[i]
        //最后求出最大值即可
        int[] dp = new int[10001];
        dp[1] = newArr[1];
        for (int i = 2; i < newArr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + newArr[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}

public class $740_DeleteAndEarn {
}
