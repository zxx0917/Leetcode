//使用DP，建立一个和矩阵相同的二维数组，dp[i][j]表示第i行j列的元素形成正方形的最大边长，判断当前元素左、上、左上元素的正方形边长
//得到如下公式：对于为'1'的元素，dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1，注意边界
//最后返回最大边长*最大边长即可
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int res = matrix[0][0] - '0';
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        if (matrix[0][0] == '1') dp[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //跳过第一个点
                if (i == 0 && j == 0) continue;

                if (matrix[i][j] == '1') {
                    //第一行
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }

                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}

public class $221_MaximalSquare {
}
