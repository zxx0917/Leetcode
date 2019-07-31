/**
 * 状态：dp[i][k]表示前i个数分割为k组的最大分数
 * 状态转移方程：从i-1开始，找到j，和A[i]组成新的一组，使得dp[i][k]最大，dp[i][k]=Math.max(dp[j][k-1]+sum(i~j)/(i-j),dp[i][k])
 * 初始化：当k=1，是dp[i][1]=第一个数到第i个数之和/i
 * 结果：返回dp[A.length][K]
 */
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        if (n == 0) return 0;
        double[][] dp = new double[n + 1][K + 1];
        //转变数组，将对应的元素累加
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        //DP
        for (int i = 1; i <= n; i++) {
            //初始化
            dp[i][1] = (double) sum[i] / i;
            //将前i个数分成k组，
            for (int k = 2; k <= K; k++) {
                //往前遍历，找出新元素以便获得最大值
                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (double) (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[A.length][K];
    }
}

public class $813_LargestSumOfAverages {
}
