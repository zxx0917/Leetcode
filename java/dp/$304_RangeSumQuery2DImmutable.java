/**
 * 动态规划，dp[i][j]为(i-1,j-1)为右下角、(0,0)为左上角的元素和
 * 当前元素和dp[i][j]=dp[i-1][j]+dp[i][j-1]+nums[i-1][j-1]-dp[i-1][j-1]
 * 这里为了防止出界，多给dp增加一行一列
 * 对于左上角(row1,col1)到右上角(row2,col2)的子矩阵元素和为dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1]+dp[row1-1][col1-1]，
 * 注意因为多添加了一行一列，所以在传入row1/col1/row2/col2时需要在原基础上+1
 * 要理解就画张图
 */
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] nums) {
        int row = nums.length;
        if (row == 0) return;
        int col = nums[0].length;

        dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + nums[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    //dp[row2][col2]-dp[row1-1][col2]-dp[row2][col1-1]+dp[row1-1][col1-1]
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

public class $304_RangeSumQuery2DImmutable {
}
