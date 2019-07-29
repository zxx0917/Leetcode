/**
 * 使用dp[i][j]表示在p[i]到p[j]石子堆中先手拿石子比对方多的石子个数。最后判断dp[0][N-1]是否大于0
 * 对于i==j，因为只有一堆石子，所以dp[i][j]=p[i]
 * 对于i < j，如果先手A获取了p[i]，则后手B比A多的石子个数为dp[i+1][j]，则在[i~j]中，A比B多p[i]-dp[i+1][j]；
 * 如果先手A获取了p[j]，则后手B比A多的石子个数为dp[i][j-1]，则在[i~j]中，A比B多p[j]-dp[i][j-1]，
 * 综上，dp[i][j]=Math.max(p[i]-dp[i+1][j],p[j]-dp[i][j-1])
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = piles[i];
                } else {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] > 0;
    }
}

public class $877_StoneGame {
}
