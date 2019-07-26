/**
 * 使用dp，dp[i]表示以A[i]为结尾的区间内包含等差子数列的个数
 * 当A[i]-A[i-1] == A[i-1]-A[i-2]时，这三个数可以构成等差数列
 * 在[0,1,2,3,4]中
 * dp[2] = 1，为[0,1,2]
 * dp[3] = 2，为[0,1,2],[1,2,3]
 * dp[4] = 3,为[0,1,2],[1,2,3],[2,3,4]
 * 所以，dp[i] = dp[i-1]+1
 * 所有最后总等差数列量为 sum += dp[i]
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0, n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}

public class $413_ArithmeticSlices {
}
