/**
 * 因为矩阵每行每列都是递减，所以可以使用二分法找出每行第一个负数的索引位置i，则负数的个数为n-i，累加每行的结果即可.
 * 这里注意特殊情况，当一行没有负数时二分法的left=grid[0].length
 */
public class $1351_CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {

        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[i][mid] >= 0) left = mid + 1;
                else right = mid - 1;
            }
            //统计每行负数的个数
            if (left < n) count += n - left;
        }
        return count;
    }
}
