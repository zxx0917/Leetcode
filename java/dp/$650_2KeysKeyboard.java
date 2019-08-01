/**
 * n 1 2 3 4 5 6 7 8 9 10
 * 0 2 3 4 5 5 7 8 6 7
 * 设定dp[i]为打印出i个A需要的最小操作次数，最后返回dp[n]即可
 * 对于质数，只能一个一个粘贴dp[i]=i，如2、3、7；
 * 对于有因数的i，假设因数为j，dp[i]=dp[j]+i/j，如对于8，可以在存在两个A时进行复制、粘贴、粘贴、粘贴，可以在存在四个A时进行复制、粘贴，
 * 所以只需要遍历2~i-1，找出i的因数，求出dp[i]的最小值即可
 * dp[i]=Math.min(dp[j]+i/j,dp[i])
 */
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            //初始化
            dp[i] = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
                }
            }
        }
        return dp[n];
    }
}

public class $650_2KeysKeyboard {
}
