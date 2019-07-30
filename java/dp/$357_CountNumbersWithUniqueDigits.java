/**
 * dp[i]为i位数的数字每位不同的数字个数
 * dp[1] = 10
 * dp[2] = 9 * 9 + dp[1] 最高位只能为1~9，第二位为与高位不同的9个数，再加上个位数的不同数字个数
 * dp[3] = 9 * 9 * 8 + dp[2] 最高位只能为1~9，第二位为与高位不同的9个数，第三位为与第二位不同的8个数，再加上两位数的不同数字个数
 * dp[i] = 9 * 9 * 8 ...*(10-i+1) + dp[i-1]
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            int count = 8;
            dp[i] = 9 * 9;
            while (count >= 10 - i + 1) {
                dp[i] *= count;
                count--;
            }
            dp[i] += dp[i - 1];
        }
        return dp[n];
    }
}

public class $357_CountNumbersWithUniqueDigits {
}
