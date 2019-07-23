/* 1.自顶向下：
 * 使用动态规划，dp[i][j]表示第i行j列的元素的最小路径和，因为对于一个元素从左上到右下有两条路可以走，即向右、向下
 * 所以从左上角开始，选取最小的一条路来计算dp[i][j]：dp[i][j] = grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j])，注意边界.
 * 最后dp[m-1][n-1]就是结果
 * 这里没采用额外空间，直接在原二维数组上修改
 *
 * 2.自底向上
 * dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j]，从右下角开始往上遍历
 */
class Solution {
    //1.自顶向下
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    //2.自底向上
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //右下角元素不处理
                if (i == m - 1 && j == n - 1) continue;
                if (i == m - 1) {
                    grid[i][j] = grid[i][j + 1] + grid[i][j];
                } else if (j == n - 1) {
                    grid[i][j] = grid[i + 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
                }
            }
        }
        return grid[0][0];
    }
}

public class $64_MinimumPathSum {
}
