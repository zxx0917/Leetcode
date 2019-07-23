/**
 * 0 0
 * 1 1
 * 2 10
 * 3 11
 * 4 100
 * 5 101
 * 6 110
 * 7 111
 * 8 1000
 * 因为要求O(n)的复杂度，所以使用动态规划，dp[i]表示数字i有的1的个数，前面0~i-1的1的个数都已有结果
 * 根据上述数字规则，可以发现如果i能被2整除，则dp[i] = dp[i/2]，如果i不能被2整除，则dp[i] = dp[i-1]+1
 */
class Solution {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                //能被2整除
                dp[i] = dp[i / 2];
            } else {
                //不能被2整除
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}

public class $338_CountingBits {
}
