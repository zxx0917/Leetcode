/**
 * 使用dp，dp[i][j]表示到达i行j列元素的下降路径最小和，最后比较最后一排元素的最小值即可
 * 对于i行j列元素的上一层元素，只能往下走，且不能超过一列，则可以从[i-1,j]/[i-1,j-1]/[i-1,j+1]到达[i,j]
 * 所以dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1])+nums[i][j]，注意边界
 * 这里在原数组上进行DP，节省空间
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        if (row == 0) return 0;

        //DP，从第二行开始
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < row; j++) {
                //边界判断
                if (j == 0) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j + 1]) + A[i][j];
                } else if (j + 1 == row) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j - 1]) + A[i][j];
                } else {
                    A[i][j] = A[i][j] = Math.min(Math.min(A[i - 1][j], A[i - 1][j - 1]), A[i - 1][j + 1]) + A[i][j];
                }
            }
        }
        //找出最小值
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            res = Math.min(res, A[row - 1][i]);
        }
        return res;
    }
}

public class $931_MinimumFallingPathSum {
}
