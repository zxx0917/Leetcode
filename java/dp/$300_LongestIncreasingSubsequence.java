
/**
 * dp[i]为第i个元素到结尾的最长上升子序列长度，从尾往头遍历，逐个求出dp[i]，
 * dp[i] = i到末尾最大的子序列长度 + 1
 * 计算时使用一个变量来保存长度最大值
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            dp[i] = 1;
            //将之后最长的子序列加入dp
            while (j < n) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

public class $300_LongestIncreasingSubsequence {
}
