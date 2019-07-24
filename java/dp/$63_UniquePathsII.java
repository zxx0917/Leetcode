// dp[i][j]表示到达i行j列的路径数，机器人只能向右、向下走，dp[i][j]=dp[i][j-1]+dp[i-1][j]，注意边界
// 如果当前点是障碍物，则d[i][j]=0。起点初始化为1，即dp[0][0]=1
// 这里在原始数组上进行计算，减少空间使用
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) return 0;
        int col = obstacleGrid[0].length;
        //如果起点就有障碍物，直接返回
        if (obstacleGrid[0][0] == 1) return 0;
        else obstacleGrid[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //跳过起点
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }

            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
}

public class $63_UniquePathsII {
}
