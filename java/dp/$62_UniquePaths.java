//使用动态规划，从底向上，dp[i][j]表示到达i行j列的路径数量，因为机器人只能向下或向右移动
//所以从右下角开始，dp[i][j] = dp[i+1][j]+dp[i][j+1]，这里需要注意边界条件
//最后返回dp[0][0]
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        //注意右下角元素为终点，则设路径数量为1
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //跳过右下角
                if (i == m - 1 && j == n - 1) continue;
                //最下面的边
                if (i == m - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == n - 1) {
                    //最右边的边
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}

public class $62_UniquePaths {
}
