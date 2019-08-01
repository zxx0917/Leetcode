/**
 * 设定dp[i][j]为从开头到A[i]、开头到B[i]的公共子数组的长度
 * 对于A[i]、B[j]，当A[i]==B[i]时，B[i]属于公共子数组，则dp[i][j]=dp[i-1][j-1]+1，当B[i]不属于公共子数组，dp[i][j]=0
 * 使用变量记录最大的公共子数组长度
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        int res = 0;
        if (aLen == 0 || bLen == 0) return 0;
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (A[i - 1] == B[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return dp[aLen][bLen];
    }
}
public class $718_MaximumLengthOfRepeatedSubarray {
}
