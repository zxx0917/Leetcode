/**
 * 遍历数组，创建四个数据，记录每个数前后左右可以炸死的敌人数，对于left[i][j]，表示(i,j)位置左边'E'的数目，如果(i,j+1)为'E'，则left[i][j]=left[i][j+1]+1；
 * 如果(i,j+1)为'0'，则left[i][j]=left[i][j+1]；当如果(i,j+1)为'W'，则left[i][j]=0。其余的前后右数组类似
 * 最后遍历数组求和的最大值即可
 */
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] front = new int[m][n];
        int[][] behind = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        //左右
        for (int i = 0; i < m; i++) {
            //左边
            for (int j = 1; j < n; j++) {
                if (grid[i][j - 1] == 'E') {
                    left[i][j] = left[i][j - 1] + 1;
                } else if (grid[i][j - 1] == '0') {
                    left[i][j] = left[i][j - 1];
                }
            }
            //右边
            for (int k = n - 2; k >= 0; k--) {
                if (grid[i][k + 1] == 'E') {
                    right[i][k] = right[i][k + 1] + 1;
                } else if (grid[i][k + 1] == '0') {
                    right[i][k] = right[i][k + 1];
                }
            }
        }
        //前后
        for (int j = 0; j < n; j++) {
            //前
            for (int i = 1; i < m; i++) {
                if (grid[i - 1][j] == 'E') {
                    front[i][j] = front[i - 1][j] + 1;
                } else if (grid[i - 1][j] == '0') {
                    front[i][j] = front[i - 1][j];
                }
            }
            //后
            for (int k = m - 2; k >= 0; k--) {
                if (grid[k + 1][j] == 'E') {
                    behind[k][j] = behind[k + 1][j] + 1;
                } else if (grid[k + 1][j] == '0') {
                    behind[k][j] = behind[k + 1][j];
                }
            }
        }

        int res = 0;
        //遍历数据，求出前后左右和的最小值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    res = Math.max(front[i][j] + behind[i][j] + left[i][j] + right[i][j], res);
            }
        }
        return res;
    }
}

public class $361_BombEnemy {
}
